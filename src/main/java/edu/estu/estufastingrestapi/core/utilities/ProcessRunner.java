package edu.estu.estufastingrestapi.core.utilities;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@UtilityClass
public class ProcessRunner {

    @SneakyThrows(IOException.class)
    public static Process run(String taskName, String directory, String... command) {
        if (command == null || command.length == 0)
            throw new IllegalArgumentException("No command found to run");
        if (taskName != null && isProcessRunningWindows(taskName)) return null;
        ProcessBuilder builder = new ProcessBuilder();
        if (directory != null) {
            builder.directory(new File(directory));
            if (!command[0].matches("[A-Z]:\\\\.*") && command[0].matches(".*\\.[A-Za-z]+") && !Files.exists(Paths.get(command[0])))
                command[0] = directory + "\\" + command[0];
        }
        builder.command(command);
        log.info("Attempting to run the command " + String.join(" ", builder.command()) + (builder.directory() == null ? "" : " in directory " + builder.directory()));
        return builder.inheritIO().start();
    }

    @SneakyThrows
    public boolean isProcessRunningWindows(String processName) {
        if (!OSHelper.getOSName().toLowerCase().contains("windows")) return false;
        Process taskList = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
        BufferedReader reader = new BufferedReader(new InputStreamReader(taskList.getInputStream()));
        String processLine = reader.lines().filter(line -> line.startsWith(processName)).findFirst().orElse(null);
        reader.close();
        return processLine != null;
    }

}
