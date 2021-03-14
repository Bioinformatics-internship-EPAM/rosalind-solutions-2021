package BioinformStrong.PRTM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;

public class Main {

    static String getDataSet(String stringWay) throws IOException {
        String s;
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            s = scanner.nextLine();
        }
        return s;
    }

    public static void main(String[] args) {

        Map<Character, Double> proteinList = Map.ofEntries (
                entry('A', 71.03711),
                entry('C', 103.00919),
                entry('D', 115.02694),
                entry('E', 129.04259),
                entry('F', 147.06841),
                entry('G', 57.02146),
                entry('H', 137.05891),
                entry('I', 113.08406),
                entry('K', 128.09496),
                entry('L', 113.08406),
                entry('M', 131.04049),
                entry('N', 114.04293),
                entry('P', 97.05276),
                entry('Q', 128.05858),
                entry('R', 156.10111),
                entry('S', 87.03203),
                entry('T', 101.04768),
                entry('V', 99.06841),
                entry('W', 186.07931),
                entry('Y', 163.0633)
        );

        String loadedData = "";
        try {
            loadedData = getDataSet("rosalind-PRTM.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        double summ = 0;

        for (int i = 0; i < loadedData.length(); i++) {

            //each letter is assigned its own mass value
            summ += proteinList.get(loadedData.charAt(i));
        }

        System.out.println(String.format("%.3f", summ));
    }
}
