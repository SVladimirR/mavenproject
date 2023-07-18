package org.example;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfiguration config = new FileLoggerConfiguration(
                "log.txt", LoggingLevel.DEBUG, 1000, "[%s][%s] Message: %s\n");
        FileLogger logger = new FileLogger(config);

        try {
            logger.debug("Debug message 1");
            logger.info("Info message 2");
            logger.debug("Debug message 3");
            logger.info("Info message 4");
        } catch (FileMaxSizeReachedException e) {
            System.out.println("File max size reached: " + e.getMessage());
        }
    }
}