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

public class CalculatingProteinMass {
    private static Map<String, String> readTable() throws IOException {
        String path = "src/covid/rosalind/massTable.txt";
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

    public static double calcMass(String str) {
        Map<String, String> table = null;
        try {
            table = readTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double res = 0;
        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));
            res += Double.parseDouble(table.get(ch));
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/covid/rosalind/calcProtein.txt";
        String pathOut = "src/covid/rosalind/calcProteinRes.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        String str = scanner.nextLine();
        double res = calcMass(str);
        fileWriter.write(String.valueOf(res));
        fileReader.close();
        fileWriter.close();
    }
}
