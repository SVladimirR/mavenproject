package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class  FileLogger {

    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        log(message, LoggingLevel.DEBUG);
    }

    public void info(String message) throws FileMaxSizeReachedException {
        log(message, LoggingLevel.INFO);
    }

    private void log(String message, LoggingLevel level) throws FileMaxSizeReachedException {
        if (level.compareTo(config.getLogLevel()) >= 0) {
            File file = new File(config.getFilePath());
            if (file.exists() && file.length() >= config.getMaxFileSize()) {
                throw new FileMaxSizeReachedException(
                        "Max file size reached. Max size: " + config.getMaxFileSize() +
                                " bytes, Current size: " + file.length() +
                                " bytes, File path: " + config.getFilePath());
            }

            String logEntry = "[" + getCurrentTime() + "]" +
                    "[" + level + "] " +
                    "Message: " + message + "\n";

            try (FileWriter writer = new FileWriter(file, true))
            {
                writer.write(logEntry);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
