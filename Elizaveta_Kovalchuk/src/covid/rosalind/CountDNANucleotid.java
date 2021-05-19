package covid.rosalind;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountDNANucleotid {

    public static int[] countNucl(String str) {
        var res = new int[]{0, 0, 0, 0};
        int i = 0;
        while (i < str.length()) {
            switch (str.charAt(i)) {
                case 'A':
                    res[0]++;
                    break;
                case 'C':
                    res[1]++;
                    break;
                case 'G':
                    res[2]++;
                    break;
                default:
                    res[3]++;
                    break;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/covid/rosalind/countNucl.txt";
        String pathOut = "src/covid/rosalind/countNuclRes.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        String str = scanner.nextLine();
        int[] res = countNucl(str);
        for (int i = 0; i < res.length; i++)
            fileWriter.write(res[i] + " ");
        fileReader.close();
        fileWriter.close();
    }
}
