package covid.rosalind;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RNAIntoProtein {

    private static  Map<String, String> readTable() throws IOException {
        String path = "src/covid/rosalind/RNAProteinTable.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        Map<String, String> table = new HashMap<>();
        for (String line : lines) {
            String[] str = line.replaceAll("\\s+", " ").split(" ");
            for (int i = 0; i < str.length - 1; i += 2) {
                int nextElem = i + 1;
                table.put(str[i], str[nextElem]);
            }
        }
        return table;
    }

    public static String createProtein(String str) {
        Map<String, String> table = null;
        try {
            table = readTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length()-3; i+= 3) {
            int end = i + 3;
            String codon = str.substring(i, end).trim();
            String protein = table.get(codon);
            if (protein.equals("Stop")) {
                result.append("\n");
            }
            result.append(protein);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/covid/rosalind/RNAIntoProtein.txt";
        String pathOut = "src/covid/rosalind/RNAIntoProteinRes.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        String str = "";
        str += scanner.nextLine();
        fileWriter.write(createProtein(str));
        fileReader.close();
        fileWriter.close();
    }
}
