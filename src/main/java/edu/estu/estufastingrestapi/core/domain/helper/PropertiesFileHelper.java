package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Helper for .properties files. Have various methods to access config key values.
 *
 * @author CosmicDust19
 * @implNote For faster access, all .properties files in src directory are searched and saved their keys and values and .env file searched
 * in src/main/resources directory and placed corresponding values in .properties files when program starts
 */
@UtilityClass
public class PropertiesFileHelper {

    private static final Map<String, Properties> PROPERTIES_MAP;

    private static final Properties ENV_MAP;

    static {
        ENV_MAP = FileHelper.findAllMatchingFiles(Paths.get("src/main/resources"), ".*\\.env")
                .map(path -> path.toAbsolutePath().toString())
                .map(FileHelper::getInputStreamFromPath)
                .map(PropertiesFileHelper::getLoadedProperties)
                .findFirst().orElse(null);

        PROPERTIES_MAP = FileHelper.findAllMatchingFiles(Paths.get("src"), ".*\\.properties")
                .map(path -> path.toAbsolutePath().toString())
                .map(absPath -> Map.entry(FileHelper.getFileNameFromAbsolutePath(absPath), FileHelper.getInputStreamFromPath(absPath)))
                .map(entry -> Map.entry(entry.getKey(), getLoadedProperties(entry.getValue())))
                .map(entry -> Map.entry(entry.getKey(), placeEnvVariables(entry.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * @param key A key which is in one of the .properties file which is in src directory
     * @return Value of the key
     * @author CosmicDust19
     */
    public static Optional<String> getByKey(String key) {
        if (key == null) return Optional.empty();
        for (Properties value : PROPERTIES_MAP.values())
            if (value.containsKey(key))
                return Optional.of(value.getProperty(key));
        return Optional.empty();
    }

    /**
     * @param regex Key regex to search in .properties files which is in src directory
     * @return Map of the found keys and their values
     * @author CosmicDust19
     */
    public static Map<String, String> getByKeyRegex(String regex) {
        Map<String, String> matchingResults = new HashMap<>();
        if (regex == null) return matchingResults;
        for (Properties value : PROPERTIES_MAP.values())
            for (Object o : value.keySet())
                if (o.toString().matches(regex))
                    matchingResults.put(o.toString(), value.getProperty(o.toString()));
        return matchingResults;
    }

    /**
     * @param fileName A file name which is has .properties extension and in src directory
     * @return Contents of the file
     * @author CosmicDust19
     */
    public static Optional<Properties> getPropertiesByFileName(String fileName) {
        for (Map.Entry<String, Properties> entry : PROPERTIES_MAP.entrySet())
            if (entry.getKey().equals(fileName))
                return Optional.ofNullable(entry.getValue());
        return Optional.empty();
    }

    @SneakyThrows(IOException.class)
    private static Properties getLoadedProperties(InputStream inStream) {
        Properties props = new Properties();
        props.load(new InputStreamReader(inStream, StandardCharsets.UTF_8));
        return props;
    }

    private static Properties placeEnvVariables(Properties props) {
        if (ENV_MAP == null) return props;
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            String value = entry.getValue().toString();
            if (value.matches(".*\\$\\{[^}]*}.*")) {
                String regex = "\\$\\{[^}]*}";
                String replacement = ENV_MAP.getProperty(StringTools.extract(value, regex).map(match -> match.substring(2, match.length() - 1)).orElse(null));
                if (replacement != null) props.replace(entry.getKey(), value.replaceAll(regex, replacement));
            }
        }
        return props;
    }

    /**
     * Special exception class for possibility of cannot to be found the key in .properties or .env files
     *
     * @author CosmicDust19
     * @implNote The following added to the beginning of the message: "Searched all .properties files in project and no keys found which satisfies this condition:"
     */
    public static class KeyNotFoundException extends RuntimeException {
        KeyNotFoundException(String keyLike) {
            super("Searched all .properties files in project and no keys found which satisfies this condition: %s".formatted(keyLike));
        }
    }

}
