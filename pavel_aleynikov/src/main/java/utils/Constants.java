package utils;

import java.util.Map;

/**
 * Constant values for tasks
 */
public class Constants {

    public static final Map<Character, Character> COMPLEMENTS = Map.of(
            'A', 'T',
            'T', 'A',
            'G', 'C',
            'C', 'G');
    public static final int CODON_LENGTH = 3;
    public static final String STOP_CODON = "Stop";
    public static final Map<String, String> RNA_CODON_TABLE = Map.ofEntries(
            Map.entry("UUU", "F"),
            Map.entry("UUC", "F"),
            Map.entry("UUA", "L"),
            Map.entry("UUG", "L"),
            Map.entry("UCU", "S"),
            Map.entry("UCC", "S"),
            Map.entry("UCA", "S"),
            Map.entry("UCG", "S"),
            Map.entry("UAU", "Y"),
            Map.entry("UAC", "Y"),
            Map.entry("UAA", STOP_CODON),
            Map.entry("UAG", STOP_CODON),
            Map.entry("UGU", "C"),
            Map.entry("UGC", "C"),
            Map.entry("UGA", STOP_CODON),
            Map.entry("UGG", "W"),
            Map.entry("CUU", "L"),
            Map.entry("CUC", "L"),
            Map.entry("CUA", "L"),
            Map.entry("CUG", "L"),
            Map.entry("CCU", "P"),
            Map.entry("CCC", "P"),
            Map.entry("CCA", "P"),
            Map.entry("CCG", "P"),
            Map.entry("CAU", "H"),
            Map.entry("CAC", "H"),
            Map.entry("CAA", "Q"),
            Map.entry("CAG", "Q"),
            Map.entry("CGU", "R"),
            Map.entry("CGC", "R"),
            Map.entry("CGA", "R"),
            Map.entry("CGG", "R"),
            Map.entry("AUU", "I"),
            Map.entry("AUC", "I"),
            Map.entry("AUA", "I"),
            Map.entry("AUG", "M"),
            Map.entry("ACU", "T"),
            Map.entry("ACC", "T"),
            Map.entry("ACA", "T"),
            Map.entry("ACG", "T"),
            Map.entry("AAU", "N"),
            Map.entry("AAC", "N"),
            Map.entry("AAA", "K"),
            Map.entry("AAG", "K"),
            Map.entry("AGU", "S"),
            Map.entry("AGC", "S"),
            Map.entry("AGA", "R"),
            Map.entry("AGG", "R"),
            Map.entry("GUU", "V"),
            Map.entry("GUC", "V"),
            Map.entry("GUA", "V"),
            Map.entry("GUG", "V"),
            Map.entry("GCU", "A"),
            Map.entry("GCC", "A"),
            Map.entry("GCA", "A"),
            Map.entry("GCG", "A"),
            Map.entry("GAU", "D"),
            Map.entry("GAC", "D"),
            Map.entry("GAA", "E"),
            Map.entry("GAG", "E"),
            Map.entry("GGU", "G"),
            Map.entry("GGC", "G"),
            Map.entry("GGA", "G"),
            Map.entry("GGG", "G"));

}
