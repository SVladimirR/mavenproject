package org.example;

import java.io.FileWriter;
import java.io.IOException;


public class ResultLogger {
    private static final String RESULT_LOG_FILE = "result.log";

    public void writeResultLog(String logEntry) throws IOException {
        try (FileWriter writer = new FileWriter(RESULT_LOG_FILE, true)) {
            writer.write(logEntry + System.lineSeparator());
        }
    }
}
