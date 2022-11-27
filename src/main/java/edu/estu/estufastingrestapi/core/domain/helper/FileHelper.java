package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@UtilityClass
public class FileHelper {

    @SneakyThrows(IOException.class)
    public Stream<Path> findAllMatchingFiles(Path start, String regex) {
        return Files.find(start, Integer.MAX_VALUE, (path, basicFileAttributes) -> path.toFile().getName().matches(regex));
    }

    public String getFileNameFromAbsolutePath(String absolutePath) {
        return StringUtils.substringAfterLast(absolutePath, '\\');
    }

    @SneakyThrows(FileNotFoundException.class)
    public InputStream getInputStreamFromPath(String path) {
        return new FileInputStream(path);
    }

}
