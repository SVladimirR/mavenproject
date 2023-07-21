package org.example;

import java.io.File;
import java.io.IOException;

public class Main23 {
    private static final String CONVERTED_FOLDER = "converted";

    public static void main(String[] args) {
        String directoryPath;
        if (args.length > 0) {
            directoryPath = args[0];
        } else {
            directoryPath = ".";
        }

        File workingDir = new File(directoryPath);
        File[] files = workingDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    processFile(file);
                }
            }
        }
    }

    private static void processFile(File inputFile) {
        String filePath = inputFile.getName();
        String extension = FileInformation.getFileExtension(filePath);

        if ("json".equalsIgnoreCase(extension) || "yaml".equalsIgnoreCase(extension) || "yml".equalsIgnoreCase(extension)) {
            try {
                String newExtension = extension.equalsIgnoreCase("json") ? "yaml" : "json";

                File convertedFolder = new File(CONVERTED_FOLDER);
                if (!convertedFolder.exists()) {
                    convertedFolder.mkdir();
                }

                File outputFile = new File(convertedFolder, FileInformation.getFileNameWithoutExtension(inputFile.getName()) + "." + newExtension);

                Converter converter = new Converter();
                String resultLogEntry = converter.convertFile(inputFile, outputFile);

                ResultLogger resultLogger = new ResultLogger();
                resultLogger.writeResultLog(resultLogEntry);
            } catch (IOException e) {
                System.out.println("Помилка при конвертації: " + e.getMessage());
            }
        }
    }
}
