package tasks;

import java.util.Map;

//Link: http://rosalind.info/problems/revc/
public class ComplementingStrandOfDna {
    private static final Map<Character, Character> complement = Map.of(
            'A', 'T',
            'T', 'A',
            'G', 'C',
            'C', 'G'
    );

    public static String compute(String dna) throws RuntimeException {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = dna.length() - 1; i >= 0; i--) {
                sb.append(complement.get(dna.charAt(i)));
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("DNA contains an erroneous symbol.", e);
        }
        return sb.toString();
    }
}
