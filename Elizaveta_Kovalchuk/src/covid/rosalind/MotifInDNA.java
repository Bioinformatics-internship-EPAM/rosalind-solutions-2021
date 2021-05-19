package covid.rosalind;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotifInDNA {

    public static List<Integer> motifDNA(String str, String s) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < str.length() && i + s.length() <= str.length()) {
            String subStr = str.substring(i, i + s.length());
            if (s.equals(subStr)) {
                res.add(i + 1);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/covid/rosalind/motifInDNA.txt";
        String pathOut = "src/covid/rosalind/motifInDNARes.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        String str = scanner.nextLine();
        String s = scanner.nextLine();
        List<Integer> res = motifDNA(str, s);
        for (Integer r : res) {
            fileWriter.write(r + " ");
        }
        fileReader.close();
        fileWriter.close();
    }
}
