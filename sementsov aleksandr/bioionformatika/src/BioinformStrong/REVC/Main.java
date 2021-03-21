package BioinformStrong.REVC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    final static String pathREVCTask = "rosalind_revc.txt";
    final static String outputPath = "submission.txt";
    
    static String getDataSet(String stringWay) throws IOException {
        String s;
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            s = scanner.nextLine();
        }
        return s;
    }

    public static void main(String[] args) {
        
        String s = "";

        //To load a dataset
        try {
            s = getDataSet(pathREVCTask);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        char[] nucleotides = new char[]{'A', 'C', 'T', 'G'};
        int j;
        //To realize the algorithm
        try {
            FileWriter writer = new FileWriter(outputPath, StandardCharsets.UTF_8);
            for (int i = s.length() - 1; i > -1; i--) {
                for (j = 0; j < nucleotides.length; j++) {
                    if (s.charAt(i) == nucleotides[j]) {
                        writer.append(nucleotides[((j + 2) % 4)]);
                    }
                }
            }
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
