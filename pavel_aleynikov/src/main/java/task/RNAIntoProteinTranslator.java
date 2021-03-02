package task;

import utils.Constants;

/**
 * Translating RNA into Protein
 *
 * http://rosalind.info/problems/prot/
 */
public class RNAIntoProteinTranslator {

    /**
     * Translating RNA into Protein
     *
     * @param rna - RNA string contains chars: {'A', 'C', 'G', 'U'}
     * @return - encoded protein string contains values from: {@link Constants#RNA_CODON_TABLE}
     */
    public static String translate(String rna) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rna.length(); i += Constants.CODON_LENGTH) {
            String s = Constants.RNA_CODON_TABLE.get(rna.substring(i, i + Constants.CODON_LENGTH));
            if (s.equals(Constants.STOP_CODON)) {
                return result.toString();
            }
            result.append(s);
        }
        return result.toString();
    }

}
