package task;

import java.util.Map;

/**
 * Counting DNA Nucleotides
 *
 * http://rosalind.info/problems/dna/
 */
public class CountDNANucleotidesCalculator {

    /**
     * Calculate count of DNA nucleotides
     *
     * @param dna - DNA string contains chars: {'A', 'C', 'G', 'T'}
     * @return - Map with key: {'A', 'C', 'G', 'T'} and their count as value
     */
    public static Map<Character, Long> calculate(final String dna) {
        long a = 0, c = 0, g = 0, t = 0;
        for (char ch : dna.toCharArray()) {
            switch (ch) {
                case 'A' -> a++;
                case 'C' -> c++;
                case 'G' -> g++;
                case 'T' -> t++;
            }
        }
        return Map.of('A', a, 'C', c, 'G', g, 'T', t);
    }

}
