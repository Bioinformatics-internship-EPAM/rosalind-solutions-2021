package tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CalculatingProteinMass {
    public static void calculateMass(String filepath) {
        String proteinString = "";
        String tableString = "";
        try {
            proteinString = new String(Files.readAllBytes(Paths.get(filepath)));
            tableString = new String(Files.readAllBytes(Paths.get("src/resources/mass_table.txt")));
        } catch (IOException e) {
            System.err.println("Exception while reading the source protein file.");
            return;
        }
        String[] mapStrings = tableString.replaceAll("\\s+", " ").split(" ");
        Map<String, Double> massTable = new HashMap<>();
        for (int i = 0; i < mapStrings.length; i = i+2) {
            if (i+1 >= mapStrings.length) {
                break;
            } else {
                massTable.put(mapStrings[i], Double.parseDouble(mapStrings[i+1]));
            }
        }
        double proteinMass = 0;
        String[] proteinChars = proteinString.split("");
        for (String c: proteinChars) {
            Double weight = massTable.get(c);
            proteinMass+=weight;
        }
        System.out.print(proteinMass);
    }
}
