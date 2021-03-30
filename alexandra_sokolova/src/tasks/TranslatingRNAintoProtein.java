package tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TranslatingRNAintoProtein {
    public static void translateRNA(String filepath) {
        String rnaString = "";
        String tableString = "";
        try {
            rnaString = new String(Files.readAllBytes(Paths.get(filepath)));
            tableString = new String(Files.readAllBytes(Paths.get("src/resources/rna_codon_table.txt")));
        } catch (IOException e) {
            System.err.println("Exception while reading the source DNA file.");
            return;
        }
        String[] mapStrings = tableString.replaceAll("\\s+", " ").split(" ");
        Map<String, String> codonTable = new HashMap<>();
        for (int i = 0; i < mapStrings.length; i = i+2) {
            if (i+1 >= mapStrings.length) {
                break;
            } else {
                codonTable.put(mapStrings[i], mapStrings[i+1]);
            }
        }
        int CODON_LENGTH = 3;
        StringBuilder proteinString = new StringBuilder();
        for (int i = 0; i < rnaString.length(); i = i + CODON_LENGTH) {
            if (i + CODON_LENGTH >= rnaString.length()) {
                break;
            }
            String codon = rnaString.substring(i, i + CODON_LENGTH);
            String aminoAcid = codonTable.get(codon);
            if (aminoAcid.equals("Stop")) {
                break;
            }
            proteinString.append(aminoAcid);
        }
        System.out.println(proteinString.toString());
    }
}
