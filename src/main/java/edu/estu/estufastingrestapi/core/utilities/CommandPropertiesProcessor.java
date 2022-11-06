package edu.estu.estufastingrestapi.core.utilities;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Order(Integer.MIN_VALUE)
public class CommandPropertiesProcessor {

    /**
     * @implNote Executes all commands upon time condition and OS
     */
    private static void runByTimeCondition(String timeCondition) {
        final Optional<String> keyRegex = buildKeyRegex(timeCondition);
        if (keyRegex.isEmpty()) return;
        PropertiesFileHelper
                .getByKeyRegex(keyRegex.get())
                .values()
                .forEach(value -> {
                    String directory = extractProperty(value, "dir");
                    String taskName = extractProperty(value, "task-name");
                    String rawCommand = extractProperty(value, "command");
                    String[] command = (rawCommand != null ? rawCommand : value.replaceAll("\\[[^]]*=[^]]*]", "")).trim().split("\s*,\s*");
                    ProcessRunner.run(taskName, directory, command);
                });
    }

    private static String extractProperty(String value, String propName) {
        Matcher matcher = Pattern.compile("\\[%s=[^]]*]".formatted(propName)).matcher(value);
        return matcher.find() ? matcher.group(0).split("=")[1].replace("]", "") : null;
    }

    private static Optional<String> buildKeyRegex(String timeCondition) {
        return PropertiesFileHelper
                .getByKey("command.key-regex-format")
                .map(s -> s.replace("{os}", getOSDescriptor())
                .replace("{time-condition}", timeCondition));
    }

    private static String getOSDescriptor() {
        final String osDescriptorKeyRegex = "os\\.descriptor\\..+";
        return PropertiesFileHelper
                .getByKeyRegex(osDescriptorKeyRegex).entrySet().stream()
                .filter(entry -> Arrays.stream(entry.getValue().split("\s*,\s*")).anyMatch(e -> e.equals(OSHelper.getOSName())))
                .findFirst()
                .orElseThrow(() -> new KeyNotFoundException("'%s' and value contains '%s'".formatted(osDescriptorKeyRegex, OSHelper.getOSName())))
                .getKey()
                .split("\\.")[2];
    }

    public static void preStartup() {
        runByTimeCondition("pre-startup");
    }

    @PostConstruct
    public void postConstruct() {
        runByTimeCondition("post-construct");
    }

    @PreDestroy
    public void preDestroy() {
        runByTimeCondition("pre-destroy");
    }

    private static class KeyNotFoundException extends RuntimeException {
        KeyNotFoundException(String keyLike) {
            super("Searched all .properties files and no keys found which satisfies this condition: %s".formatted(keyLike));
        }
    }
}
