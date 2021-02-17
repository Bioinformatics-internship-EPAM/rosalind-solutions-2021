package ru.spbstu.tasks;

import ru.spbstu.utils.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProteinMassTask {
    private String proteinString;
    private Map<String, String> weights = new HashMap<>();

    public ProteinMassTask(String proteinString) {
        this.proteinString = proteinString;
    }

    public Double countWeight() throws IOException {
        weights = FileUtils.readTableAndReturnMap("monoisotopic_mass_table.txt");
        return proteinString.chars()
                .mapToDouble(c -> Double.parseDouble(weights.get(String.valueOf((char) c))))
                .sum();
    }
}
