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
    public static Map<Character, Integer> calculate(String dna) {
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;
        for (int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'A' -> a++;
                case 'C' -> c++;
                case 'G' -> g++;
                case 'T' -> t++;
            }
        }
        return Map.of('A', a, 'C', c, 'G', g, 'T', t);
    }

}
