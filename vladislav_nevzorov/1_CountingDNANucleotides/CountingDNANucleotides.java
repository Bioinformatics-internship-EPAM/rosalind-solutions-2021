package my.rosalind;

import java.util.HashMap;

public class CountingDNANucleotides {
    private char[] getAlhpabet() {
        return new char[] {'A', 'C', 'G', 'T'};
    }

    public int[] exec(String dataset) {
        char[] alphabet = getAlhpabet();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char symbol : alphabet) {
            map.put(symbol, 0);
        }

        for (char symbol : dataset.toCharArray()) {
            Integer value = map.get(symbol);
            if (value == null) {
                continue;
            }
            map.replace(symbol, ++value);
        }

        int[] result = new int[alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            char symbol = alphabet[i];
            result[i] = map.get(symbol);
        }

        return result;
    }
}