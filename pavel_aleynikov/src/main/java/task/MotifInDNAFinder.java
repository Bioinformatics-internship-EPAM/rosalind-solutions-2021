package task;

import java.util.ArrayList;
import java.util.List;

/**
 * Finding a Motif in DNA
 *
 * http://rosalind.info/problems/subs/
 */
public class MotifInDNAFinder {

    /**
     * Find  all locations of substring in DNA
     *
     * @param dna - DNA string contains chars: {'A', 'C', 'G', 'T'}
     * @param substring - DNA substring
     * @return - all start index of substring in dna. Index start from 1, not from 0
     */
    public static List<Integer> findAll(String dna, String substring) {
        List<Integer> result = new ArrayList<>();
        if (substring.length() > dna.length()) {
            return result;
        }
        int index = 0;
        while (true) {
            index = dna.indexOf(substring, index);
            if (index == -1) {
                return result;
            }
            result.add(++index);
        }
    }
}
