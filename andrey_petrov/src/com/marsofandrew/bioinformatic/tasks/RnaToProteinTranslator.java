package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

import java.util.HashMap;
import java.util.Map;

public class RnaToProteinTranslator {

    private final static Character STOP_SYMBOL = 'Z'; // In accordance to theory there is no protein Z
    private final static Map<CharSequence, Character> RNA_CODON_TABLE = new HashMap<>() {{
        put("UUU", 'F');
        put("UUC", 'F');
        put("UUA", 'L');
        put("UUG", 'L');
        put("CUU", 'L');
        put("CUC", 'L');
        put("CUA", 'L');
        put("CUG", 'L');
        put("UCU", 'S');
        put("UCC", 'S');
        put("UCA", 'S');
        put("UCG", 'S');
        put("UAU", 'Y');
        put("UAC", 'Y');
        put("AUU", 'I');
        put("AUC", 'I');
        put("AUA", 'I');
        put("GUU", 'V');
        put("GUC", 'V');
        put("GUA", 'V');
        put("GUG", 'V');
        put("AUG", 'M');
        put("CCU", 'P');
        put("CCC", 'P');
        put("CCA", 'P');
        put("CCG", 'P');
        put("ACU", 'T');
        put("ACC", 'T');
        put("ACA", 'T');
        put("ACG", 'T');
        put("GCU", 'A');
        put("GCC", 'A');
        put("GCA", 'A');
        put("GCG", 'A');
        put("CAU", 'H');
        put("CAC", 'H');
        put("AAU", 'N');
        put("AAC", 'N');
        put("GAU", 'D');
        put("GAC", 'D');
        put("CAA", 'Q');
        put("CAG", 'Q');
        put("AAA", 'K');
        put("AAG", 'K');
        put("GAA", 'E');
        put("GAG", 'E');
        put("UGU", 'C');
        put("UGC", 'C');
        put("CGU", 'R');
        put("CGC", 'R');
        put("CGA", 'R');
        put("AGA", 'R');
        put("CGG", 'R');
        put("AGG", 'R');
        put("AGU", 'S');
        put("AGC", 'S');
        put("GGU", 'G');
        put("GGC", 'G');
        put("GGA", 'G');
        put("GGG", 'G');
        put("UGG", 'W');
        put("UAA", STOP_SYMBOL);
        put("UAG", STOP_SYMBOL);
        put("UGA", STOP_SYMBOL);
    }};

    public static String convert(final String rna) {
        if (rna == null) {
            throw new IllegalArgumentException("RNA couldn't be null");
        }

        StringBuilder proteins = new StringBuilder();
        String rnaUpper = rna.toUpperCase();
        while (!rnaUpper.isEmpty()) {
            String group = rnaUpper.substring(0, 3);
            Character protein = RNA_CODON_TABLE.get(group);
            if (protein.equals(STOP_SYMBOL)) {
                break;
            }
            proteins.append(protein);
            rnaUpper = rnaUpper.substring(3);
        }
        return proteins.toString();
    }

    public static void main(String[] args) {
        Helpers.executeStringInput(RnaToProteinTranslator::convert, rna -> {
            if (rna.length() > 10_000) {
                throw new IllegalArgumentException("Max size of RNA is 10_000");
            }
        });
    }
}
