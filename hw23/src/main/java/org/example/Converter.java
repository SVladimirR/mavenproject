package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Converter {
    private ObjectMapper jsonMapper;
    private Yaml yamlMapper;

    public Converter() {
        jsonMapper = new ObjectMapper();
        yamlMapper = createYaml();
    }

    public String convertFile(File inputFile, File outputFile) throws IOException {
        String inputFileName = inputFile.getName();
        String outputFileName = outputFile.getName();

        long startTime = System.currentTimeMillis();
        if (inputFileName.endsWith(".json")) {
            List<Map<String, Object>> jsonList = jsonMapper.readValue(inputFile, List.class);
            try (FileWriter writer = new FileWriter(outputFile)) {
                yamlMapper.dump(jsonList, writer);
            }
        } else if (inputFileName.endsWith(".yaml") || inputFileName.endsWith(".yml")) {
            try (FileReader reader = new FileReader(inputFile);
                 FileWriter writer = new FileWriter(outputFile)) {
                List<Map<String, Object>> yamlList = yamlMapper.load(reader);
                jsonMapper.writeValue(writer, yamlList);
            }
        } else {
            return inputFileName + " -> " + outputFileName + ", Формат непідтримуваного файлу";
        }
        long endTime = System.currentTimeMillis();

        long inputFileSize = inputFile.length();
        long outputFileSize = outputFile.length();

        return inputFileName + " -> " + outputFileName + ", " +
                "Час конвертації: " + (endTime - startTime) + " мс, " +
                "Старий розмір: " + inputFileSize + " байт -> " +
                "Новий розмір: " + outputFileSize + " байт";
    }

    private Yaml createYaml() {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
        return new Yaml(options);
    }
}
