package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Processor for command.properties file. Runs specified commands according to operating system when time condition satisfied.
 */
@Slf4j
@Component
@Order(Integer.MIN_VALUE)
public class CommandPropertiesProcessor {

    public static final boolean ENABLED;

    private static final String DEFAULT_COMMAND_EXEC_KEY_STRUCTURE;
    private static final String DEFAULT_COMMAND_OS_KEY_STRUCTURE;
    private static final Map<String, String> DEFAULT_COMMAND_OS_MAP;

    private static final String COMMAND_EXEC_KEY_STRUCTURE;
    private static final String COMMAND_OS_KEY_REGEX;
    private static final String OS_DESCRIPTOR;

    static {
        ENABLED = PropertiesFileHelper.getPropertiesByFileName("command.properties").isPresent();

        DEFAULT_COMMAND_EXEC_KEY_STRUCTURE = "command\\.exec\\.{time-condition}\\.{os}\\..*";
        DEFAULT_COMMAND_OS_KEY_STRUCTURE = "command\\.os\\.{os-name}";

        DEFAULT_COMMAND_OS_MAP = new HashMap<>();
        DEFAULT_COMMAND_OS_MAP.put("command.os.windows", "Windows 11, Windows 10, Windows 8.1, Windows 7");
        DEFAULT_COMMAND_OS_MAP.put("command.os.linux", "Linux");
        DEFAULT_COMMAND_OS_MAP.put("command.os.mac-os-x", "Mac OS X");

        COMMAND_EXEC_KEY_STRUCTURE = PropertiesFileHelper.getByKey("command.key-structure.exec")
                .orElse(DEFAULT_COMMAND_EXEC_KEY_STRUCTURE);

        COMMAND_OS_KEY_REGEX = PropertiesFileHelper.getByKey("command.key-structure.os")
                .orElse(DEFAULT_COMMAND_OS_KEY_STRUCTURE)
                .replace("{os-name}", ".+");

        Map<String, String> commandOSMap = PropertiesFileHelper.getByKeyRegex(COMMAND_OS_KEY_REGEX);
        DEFAULT_COMMAND_OS_MAP.forEach(commandOSMap::putIfAbsent);
        OS_DESCRIPTOR = commandOSMap.entrySet().stream()
                .filter(entry -> Arrays.stream(entry.getValue().split("\s*,\s*")).anyMatch(e -> e.equals(OSHelper.getOSName())))
                .findFirst()
                .orElseThrow(() -> new PropertiesFileHelper.KeyNotFoundException("key regex '%s' & value contains '%s'".formatted(COMMAND_OS_KEY_REGEX, OSHelper.getOSName())))
                .getKey().transform(key -> key.substring(key.lastIndexOf('.') + 1));
    }

    public static void startedEvent() {
        runByTimeCondition("started");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent() {
        runByTimeCondition("application-ready");
    }

    @EventListener(ContextClosedEvent.class)
    public void contextClosedEvent() {
        runByTimeCondition("context-closed");
    }

    /**
     * Executes all commands upon time condition and OS
     */
    private static void runByTimeCondition(@NonNull String timeCondition) {
        if (!ENABLED) return;
        PropertiesFileHelper.getByKeyRegex(buildKeyRegex(timeCondition)).values().forEach(value -> {
            String[] command = extractProperty(value, "command")
                    .orElseGet(() -> value.replaceAll("\\[[^]]*=[^]]*]", ""))
                    .trim().split("\s*,\s*");
            ProcessRunner.run(extractProperty(value, "dir").orElse(null), command);
        });
    }

    private static Optional<String> extractProperty(String value, String propName) {
        return StringTools.extract(value, "\\[%s=[^]]*]".formatted(propName))
                .map(match -> match.split("=")[1].replace("]", ""));
    }

    private static String buildKeyRegex(String timeCondition) {
        if (timeCondition == null || OS_DESCRIPTOR == null) return null;
        return COMMAND_EXEC_KEY_STRUCTURE.transform(s ->
                s.replace("{os}", OS_DESCRIPTOR).replace("{time-condition}", timeCondition)
        );
    }

}
