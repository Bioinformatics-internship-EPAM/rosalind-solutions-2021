import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task5 {
    public static Map<String, String> proteinAbbreviations;
    public static final int CODON_LENGTH = 3;
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

    public static String getProteinString(final String rnaString) {
        // in prod we should check that it's AUCG string and that the length is divisible by 3.
        // we can also use stop sequences here, but it's not asked.
        return IntStream
                .iterate(0, i -> i + CODON_LENGTH)
                .limit((int) Math.ceil((double) rnaString.length() / CODON_LENGTH))
                .mapToObj(i -> rnaString.substring(i, i + CODON_LENGTH))
                .map(nuclTriplet -> proteinAbbreviations.get(nuclTriplet))
                .collect(Collectors.joining());
    }
}
