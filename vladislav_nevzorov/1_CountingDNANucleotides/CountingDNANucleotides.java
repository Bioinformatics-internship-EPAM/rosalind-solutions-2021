package my.rosalind;

import java.util.Arrays;
import java.util.HashMap;

public class CountingDNANucleotides {
    private Character[] getAlhpabet() { return new Character[] {'A', 'C', 'G', 'T'}; }

    public int[] exec(String dataset) {
        var alphabet = getAlhpabet();
        var map = new HashMap<Character, Integer>();

        for (char symbol : alphabet) {
            map.put(symbol, 0);
        }

        for (int i = 0; i < dataset.length(); i++) {
            var symbol = dataset.charAt(i);
            map.compute(symbol, (k, v) -> v != null ? ++v : v);
        }

        return Arrays.stream(alphabet).mapToInt(map::get).toArray();
    }
}
