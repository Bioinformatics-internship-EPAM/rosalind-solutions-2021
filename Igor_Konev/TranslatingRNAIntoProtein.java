import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class TranslatingRNAIntoProtein {
    private final static Map<String, String> codonsMap = Map.ofEntries(
            entry("UUU", "F"), entry("CUU", "L"), entry("AUU", "I"),
            entry("GUU", "V"), entry("UUC", "F"), entry("CUC", "L"),
            entry("AUC", "I"), entry("GUC", "V"), entry("UUA", "L"),
            entry("CUA", "L"), entry("AUA", "I"), entry("GUA", "V"),
            entry("UUG", "L"), entry("CUG", "L"), entry("AUG", "M"),
            entry("GUG", "V"), entry("UCU", "S"), entry("CCU", "P"),
            entry("ACU", "T"), entry("GCU", "A"), entry("UCC", "S"),
            entry("CCC", "P"), entry("ACC", "T"), entry("GCC", "A"),
            entry("UCA", "S"), entry("CCA", "P"), entry("ACA", "T"),
            entry("GCA", "A"), entry("UCG", "S"), entry("CCG", "P"),
            entry("ACG", "T"), entry("GCG", "A"), entry("UAU", "Y"),
            entry("CAU", "H"), entry("AAU", "N"), entry("GAU", "D"),
            entry("UAC", "Y"), entry("CAC", "H"), entry("AAC", "N"),
            entry("GAC", "D"), entry("UAA", "Stop"), entry("CAA", "Q"),
            entry("AAA", "K"), entry("GAA", "E"), entry("UAG", "Stop"),
            entry("CAG", "Q"), entry("AAG", "K"), entry("GAG", "E"),
            entry("UGU", "C"), entry("CGU", "R"), entry("AGU", "S"),
            entry("GGU", "G"), entry("UGC", "C"), entry("CGC", "R"),
            entry("AGC", "S"), entry("GGC", "G"), entry("UGA", "Stop"),
            entry("CGA", "R"), entry("AGA", "R"), entry("GGA", "G"),
            entry("UGG", "W"), entry("CGG", "R"), entry("AGG", "R"),
            entry("GGG", "G")
    );

    public static void main(String[] args) throws Exception {
        try (InputStream dataset = new FileInputStream("/tmp/rosalind_prot.txt")) {
            final String protein = readRNAFromFileAndConvertIntoProtein(dataset);
            System.out.println(protein);
        }
    }

    public static String readRNAFromFileAndConvertIntoProtein(final InputStream inputStream)
            throws IOException {
        final StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            char[] codon = new char[3];
            // Read file by three elements to convert them into acid
            while ((br.read(codon, 0, 3)) == 3) {
                final String acid = codonsMap.getOrDefault(String.valueOf(codon), "");
                if (acid.equals("Stop")) {
                    break;
                }
                resultStringBuilder.append(acid);
            }
        }
        return resultStringBuilder.toString();
    }
}
