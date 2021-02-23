package my.rosalind;

import java.util.HashMap;

public class CountingDNANucleotides {
    private char[] getAlhpabet() { return new char[] {'A', 'C', 'G', 'T'}; }

    public int[] exec(String dataset) {
        var alphabet = getAlhpabet();
        var map = new HashMap<Character, Integer>();

        for (char symbol : alphabet) {
            map.put(symbol, 0);
        }

        for (var symbol : dataset.toCharArray()) {
            var value = map.get(symbol);
            if (value == null) {
                continue;
            }
            map.replace(symbol, ++value);
        }

        var result = new int[alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            var symbol = alphabet[i];
            result[i] = map.get(symbol);
        }

        return result;
    }
}