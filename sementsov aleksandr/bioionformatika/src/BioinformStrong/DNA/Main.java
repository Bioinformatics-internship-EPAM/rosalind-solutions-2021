package BioinformStrong.DNA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    final static String pathDNATask = "rosalind_DNA.txt";

    static String getDataSet() throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(Main.pathDNATask.toLowerCase(), StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            return scanner.nextLine();
        }
    }

    public static void main(String[] args) {

        //To load a dataset
        String sourceData = "";
        try {
            sourceData = getDataSet();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        char[] nucleotides = {'A', 'C', 'G', 'T'};
        long freq;

        //To realize the algorithm
        for (char nucleotide : nucleotides) {
            freq = sourceData.chars().filter(ch -> ch == nucleotide).count();
            System.out.printf("%d ", freq);
        }
    }
}
