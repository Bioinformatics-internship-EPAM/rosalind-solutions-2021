package ru.spbstu.goloskov;

import com.google.common.base.Splitter;
import ru.spbstu.goloskov.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatingProteinMassTask {

    private static final String MONOISOTOPIC_MASS_TABLE = "MonoisotopicMassTable.txt";

    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readFile(Utils.CALCULATING_PROTEIN_MASS);
        Map<String, Double> symbolToWeight = getMonoisotopicMassTable();
        Double totalWeight = 0.0;
        for (char symbol : lines.get(0).toCharArray()) {
            totalWeight += symbolToWeight.get(String.valueOf(symbol));
        }
        System.out.printf("%.3f", totalWeight);
    }

    private static Map<String, Double> getMonoisotopicMassTable() throws URISyntaxException, IOException {
        Map<String, Double> symbolToWeight = new HashMap<>();
        List<String> lines = Utils.readFile(MONOISOTOPIC_MASS_TABLE);
        for (String line : lines) {
            String[] pair = line.split("\\s\\s+");
            symbolToWeight.put(pair[0], Double.valueOf(pair[1]));
        }
        return symbolToWeight;
    }
}
