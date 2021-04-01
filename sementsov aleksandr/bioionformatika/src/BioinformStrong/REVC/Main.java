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

    /** alphabet of nucleotides */
    static char[] nucleotides = {'A', 'C', 'T', 'G'};
    
    static String getDataSet() throws IOException {
        String s;
        try (BufferedReader brReader = new BufferedReader(new FileReader(Main.pathREVCTask, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            s = scanner.nextLine();
        }
        return s;
    }

    static void alternationElements(String sampleInfo) throws IOException {
        FileWriter writer = new FileWriter(outputPath, StandardCharsets.UTF_8);
        for (int indexInSample = sampleInfo.length() - 1; indexInSample > -1; indexInSample--) {
            for (int nucleotideNumber = 0; nucleotideNumber < nucleotides.length; nucleotideNumber++) {
                if (sampleInfo.charAt(indexInSample) == nucleotides[nucleotideNumber]) {
                    writer.append(nucleotides[((nucleotideNumber + 2) % 4)]);
                }
            }
        }
        writer.close();
    }

    public static void main(String[] args) {
        
        String sampleInfo;
        try {

            //To load a dataset
            sampleInfo = getDataSet();

            // replace through the element using alternation
            alternationElements(sampleInfo);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
