package task;

/**
 * Counting Point Mutations
 *
 * http://rosalind.info/problems/hamm/
 */
public class CountPointMutationsCalculator {

    /**
     * Calculate Hamming distance between two strings
     *
     * @param dnaFirst - DNA string contains chars: {'A', 'C', 'G', 'T'}
     * @param dnaSecond - DNA string must be equal to the first in length
     * @return - Hamming distance
     */
    public static int calculate(String dnaFirst, String dnaSecond) {
        if (dnaFirst.length() != dnaSecond.length()) {
            throw new IllegalArgumentException("Sequences must be the same length");
        }
        int result = 0;
        for (int i = 0; i < dnaFirst.length(); i++) {
            if (dnaFirst.charAt(i) != dnaSecond.charAt(i)) {
                result++;
            }
        }
        return result;
    }

}
