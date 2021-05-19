package covid.rosalind;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ComplDNA {

    public static String complementingDNA(String str) {
        StringBuffer rts = (new StringBuffer(str)).reverse();
        int i = 0;
        while (i < rts.length()) {
            switch (rts.charAt(i)) {
                case 'A':
                    rts.setCharAt(i, 'T');
                    break;
                case 'T':
                    rts.setCharAt(i, 'A');
                    break;
                case 'C':
                    rts.setCharAt(i, 'G');
                    break;
                default:
                    rts.setCharAt(i, 'C');
                    break;
            }
            i++;
        }
        return rts.toString();
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/covid/rosalind/complDNa.txt";
        String pathOut = "src/covid/rosalind/complDNaRes.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        String str = scanner.nextLine();
        fileWriter.write(complementingDNA(str));
        fileReader.close();
        fileWriter.close();
    }
}
