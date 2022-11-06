package edu.estu.estufastingrestapi.core.utilities;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

@UtilityClass
public class PropertiesFileHelper {

    public static final String PROJECT_PATH;

    public static final String PROJECT_NAME;

    private static final Map<String, Properties> PROPERTIES_MAP;

    static {
        PROJECT_PATH = Paths.get("").toAbsolutePath().toString();

        PROJECT_NAME = FileHelper.getFileNameFromAbsolutePath(PROJECT_PATH);

        PROPERTIES_MAP = FileHelper.findAllFilesMatch(Paths.get("src"), ".*\\.properties")
                .map(path -> path.toAbsolutePath().toString())
                .map(absPath -> Map.entry(FileHelper.getFileNameFromAbsolutePath(absPath), FileHelper.getInputStreamFromPath(absPath)))
                .map(entry -> Map.entry(entry.getKey(), mapInputStreamToProperties(entry.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Optional<String> getByKey(String key) {
        for (Properties value : PROPERTIES_MAP.values())
            if (value.containsKey(key))
                return Optional.of(value.getProperty(key));
        return Optional.empty();
    }

    public static Map<String, String> getByKeyRegex(String regex) {
        Map<String, String> matchingResults = new HashMap<>();
        for (Properties value : PROPERTIES_MAP.values())
            for (Object o : value.keySet())
                if (o.toString().matches(regex))
                    matchingResults.put(o.toString(), value.getProperty(o.toString()));
        return matchingResults;
    }

    @SneakyThrows
    private static Properties mapInputStreamToProperties(InputStream inStream) {
        Properties props = new Properties();
        props.load(inStream);
        return props;
    }


}
