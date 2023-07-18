package org.example;

import lombok.Data;

@Data
public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel logLevel;
    private Integer maxFileSize;
    private String logFormat;

    public FileLoggerConfiguration(String filePath, LoggingLevel logLevel, Integer maxFileSize, String logFormat) {
        this.filePath = filePath;
        this.logLevel = logLevel;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
    }
}
