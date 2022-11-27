package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@UtilityClass
public class ProcessRunner {

    private Stream<ProcessHandle> processHandles;
    private Long lastUpdated;

    /**
     * Runs the command in the given directory.
     *
     * @param command   Command to run
     * @param directory Directory to run the command in
     * @return Optional of started process if command length is greater than 0 and task is not running and directory exists, otherwise optional empty
     * @author CosmicDust19
     */
    @SneakyThrows({IOException.class})
    public synchronized Optional<Process> run(String directory, String... command) {
        if (!validCommand(command) || alreadyRunning(String.join(" ", command))) return Optional.empty();
        ProcessBuilder builder = new ProcessBuilder();
        if (validDirectory(directory)) builder.directory(new File(directory));
        builder.command(command);
        log.info("Attempting to run the command " + String.join(" ", builder.command()) + (builder.directory() == null ? "" : " in directory " + builder.directory()));
        return Optional.of(builder.inheritIO().start());
    }

    private boolean validCommand(String[] command) {
        if (command != null && command.length > 0) return true;
        log.error("No command found to run.");
        return false;
    }

    private boolean validDirectory(String directory) {
        if (directory != null && Files.notExists(Paths.get(directory)))
            log.error("The directory does not exist: '{}'", directory);
        return directory != null;
    }

    /**
     * @return True if any of existing process command has levenshtein distance between parameter command smaller than 10, else false
     */
    private boolean alreadyRunning(String command) {
        return command != null && getProcessHandles()
                .anyMatch(p -> StringTools.extract(command, "[A-Z]:\\\\([^[\\\\/:*?\"<>|]]+\\\\)*[^[\\\\/:*?\"<>|]]*\\.[A-Za-z]+").orElse("$$$").equals(p.info().command().orElse(null)));
    }

    private Stream<ProcessHandle> getProcessHandles() {
        if (processHandles == null || lastUpdated == null || System.currentTimeMillis() - lastUpdated > 1000 * 15) {
            processHandles = ProcessHandle.allProcesses().parallel();
            lastUpdated = System.currentTimeMillis();
            return processHandles;
        }
        return processHandles;
    }

}
