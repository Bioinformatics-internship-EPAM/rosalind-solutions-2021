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
    public static int calculate(final String dnaFirst, final String dnaSecond) {
        if (dnaFirst.length() != dnaSecond.length()) {
            throw new IllegalArgumentException("Sequences must be the same length");
        }
        final char [] dnaFirstArray = dnaFirst.toCharArray();
        final char [] dnaSecondArray = dnaSecond.toCharArray();
        int result = 0;
        for (int i = 0; i < dnaFirst.length(); i++) {
            if (dnaFirstArray[i] != dnaSecondArray[i]) {
                result++;
            }
        }
        return result;
    }


}
