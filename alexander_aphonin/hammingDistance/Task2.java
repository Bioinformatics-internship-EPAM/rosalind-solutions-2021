public class Task2 {

    public static int evalHammingDistance(final String dnaSeq1, final String dnaSeq2)
            throws IllegalArgumentException {
        // Didn't find a nice solutions through streams. If review has a concept, would be nice to know
        final int firstStringLength = dnaSeq1.length();
        final int secondStringLength = dnaSeq2.length();
        if (firstStringLength != secondStringLength) {
            throw new IllegalArgumentException("DNA sequences must be of same length");
        }

        int hammingDistanceCounter = 0;
        for (int i = 0; i < firstStringLength; i++) {
            if (dnaSeq1.charAt(i) != dnaSeq2.charAt(i)) {
                hammingDistanceCounter++;
            }
        }
        return hammingDistanceCounter;
    }
}
