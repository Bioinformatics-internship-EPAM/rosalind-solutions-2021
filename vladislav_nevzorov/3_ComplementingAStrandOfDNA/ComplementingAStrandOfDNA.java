package my.rosalind;

import java.util.HashMap;
import java.util.Map;

public class ComplementingAStrandOfDNA {
    private Map getPairsMap() {
        var pairs = new HashMap<>();
        pairs.put('A', 'T');
        pairs.put('T', 'A');
        pairs.put('C', 'G');
        pairs.put('G', 'C');

        return pairs;
    }

    public String exec(String dna) {
        var pairs = getPairsMap();

        var builder = new StringBuilder();
        for (int i = dna.length() - 1; i >= 0; i--) {
            var symbol = dna.charAt(i);
            var reversed = pairs.get(symbol);
            builder.append(reversed);
        }

        return builder.toString();
    }
}
