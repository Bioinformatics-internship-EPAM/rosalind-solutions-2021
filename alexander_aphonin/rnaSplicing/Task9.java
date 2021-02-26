import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Task9 {

    public static final Map<String, String> proteinAbbreviations;
    //Map.of(); doesn't work for 64 pairs.
    static {
        proteinAbbreviations = new HashMap<>();
        proteinAbbreviations.put("UUU", "F");
        proteinAbbreviations.put("UUC", "F");
        proteinAbbreviations.put("UUA", "L");
        proteinAbbreviations.put("UUG", "L");
        proteinAbbreviations.put("UCU", "S");
        proteinAbbreviations.put("UCC", "S");
        proteinAbbreviations.put("UCA", "S");
        proteinAbbreviations.put("UCG", "S");
        proteinAbbreviations.put("UAU", "Y");
        proteinAbbreviations.put("UAC", "Y");
        proteinAbbreviations.put("UAA", "");
        proteinAbbreviations.put("UAG", "");
        proteinAbbreviations.put("UGU", "C");
        proteinAbbreviations.put("UGC", "C");
        proteinAbbreviations.put("UGA", "");
        proteinAbbreviations.put("UGG", "W");
        proteinAbbreviations.put("CUU", "L");
        proteinAbbreviations.put("CUC", "L");
        proteinAbbreviations.put("CUA", "L");
        proteinAbbreviations.put("CUG", "L");
        proteinAbbreviations.put("CCU", "P");
        proteinAbbreviations.put("CCC", "P");
        proteinAbbreviations.put("CCA", "P");
        proteinAbbreviations.put("CCG", "P");
        proteinAbbreviations.put("CAU", "H");
        proteinAbbreviations.put("CAC", "H");
        proteinAbbreviations.put("CAA", "Q");
        proteinAbbreviations.put("CAG", "Q");
        proteinAbbreviations.put("CGU", "R");
        proteinAbbreviations.put("CGC", "R");
        proteinAbbreviations.put("CGA", "R");
        proteinAbbreviations.put("CGG", "R");
        proteinAbbreviations.put("AUU", "I");
        proteinAbbreviations.put("AUC", "I");
        proteinAbbreviations.put("AUA", "I");
        proteinAbbreviations.put("AUG", "M");
        proteinAbbreviations.put("ACU", "T");
        proteinAbbreviations.put("ACC", "T");
        proteinAbbreviations.put("ACA", "T");
        proteinAbbreviations.put("ACG", "T");
        proteinAbbreviations.put("AAU", "N");
        proteinAbbreviations.put("AAC", "N");
        proteinAbbreviations.put("AAA", "K");
        proteinAbbreviations.put("AAG", "K");
        proteinAbbreviations.put("AGU", "S");
        proteinAbbreviations.put("AGC", "S");
        proteinAbbreviations.put("AGA", "R");
        proteinAbbreviations.put("AGG", "R");
        proteinAbbreviations.put("GUU", "V");
        proteinAbbreviations.put("GUC", "V");
        proteinAbbreviations.put("GUA", "V");
        proteinAbbreviations.put("GUG", "V");
        proteinAbbreviations.put("GCU", "A");
        proteinAbbreviations.put("GCC", "A");
        proteinAbbreviations.put("GCA", "A");
        proteinAbbreviations.put("GCG", "A");
        proteinAbbreviations.put("GAU", "D");
        proteinAbbreviations.put("GAC", "D");
        proteinAbbreviations.put("GAA", "E");
        proteinAbbreviations.put("GAG", "E");
        proteinAbbreviations.put("GGU", "G");
        proteinAbbreviations.put("GGC", "G");
        proteinAbbreviations.put("GGA", "G");
        proteinAbbreviations.put("GGG", "G");
    }
    public static List<String> readFastaFile(final String fastaFilename) {
        List<String> dnaStrings = new LinkedList<>(); // we only save data as the id is unnecessary
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(new FileInputStream(fastaFilename)))) {
            String line;
            boolean first = true;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '>') {
                    if (first) {
                        first = false;
                        continue;
                    }
                    dnaStrings.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                } else {
                    stringBuilder.append(line);
                }
            }
            dnaStrings.add(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dnaStrings;
    }
    public static String createProteinString(final String filename) {
        List<String> fileData = readFastaFile(filename);
        String dnaSequence = fileData.get(0);
        fileData.remove(0);

        // we exclude the dna string itself. to only erase introns.
        dnaSequence = fileData.stream().reduce(dnaSequence, (str,intron) -> str.replaceAll(intron, ""));
                //.forEach(val -> dnaSequenceEntry.setValue())

        final String rnaSequence = Task4.getTranscribedRna(dnaSequence);
        return Task5.getProteinString(rnaSequence);
    }

}
