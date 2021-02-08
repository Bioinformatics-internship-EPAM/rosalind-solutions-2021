package ru.spbstu.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProteinMassTask {
    private String proteinString;
    private Map<String, Double> weights = new HashMap<>();

    public ProteinMassTask(String proteinString) {
        this.proteinString = proteinString;
    }

    private void readMassTable() throws IOException {
        Path path = Paths.get("monoisotopic_mass_table.txt");
        List<String> lines = Files.readAllLines(path);
        for (String str : lines) {
            String[] split = str.replaceAll("\\s+"," ").split(" ");
            if (split.length != 2) {
                System.err.println("Wrong format of string: "+ str);
            } else {
                this.weights.put(split[0], Double.valueOf(split[1]));
            }
        }
    }

    public Double countWeight() throws IOException {
        readMassTable();
        return proteinString.chars().mapToDouble(c -> weights.get(String.valueOf((char)c))).sum();
    }
}
