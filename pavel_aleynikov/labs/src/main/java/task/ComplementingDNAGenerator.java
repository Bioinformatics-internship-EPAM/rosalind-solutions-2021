package task;

import utils.Constants;

/**
 * Complementing a Strand of DNA
 * <p>
 * http://rosalind.info/problems/revc/
 */
public class ComplementingDNAGenerator {

    /**
     * Generate complementing DNA
     *
     * @param dna - DNA string contains chars: {'A', 'C', 'G', 'T'}
     * @return - reverse complement of DNA. String contains chars: {'A', 'C', 'G', 'T'}
     */
    public static String generate(String dna) {
        char[] result = new char[dna.length()];
        for (int i = 0; i < dna.length(); i++) {
            result[i] = Constants.COMPLEMENTS.get(dna.charAt(dna.length() - i - 1));
        }
        return String.valueOf(result);
    }

}
