package edu.estu.estufastingrestapi.core.utilities;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


@UtilityClass
public class FileHelper {

    @SneakyThrows
    public static Stream<Path> findAllFilesMatch(Path start, String regex) {
        return Files.find(start, Integer.MAX_VALUE, (path, basicFileAttributes) -> path.toFile().getName().matches(regex));
    }

    public static String getFileNameFromAbsolutePath(String absolutePath) {
        return absolutePath.substring(absolutePath.lastIndexOf('\\') + 1);
    }

    @SneakyThrows
    public static InputStream getInputStreamFromPath(String path) {
        return new FileInputStream(path);
    }

}
