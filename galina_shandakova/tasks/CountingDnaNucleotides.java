package tasks;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

//Link : http://rosalind.info/problems/dna/
public class CountingDnaNucleotides {
    public static void countFromString(String dna) {
        if (dna.isEmpty()) return;
        Map<Character, Integer> frequencies = dna.chars().boxed()
                .collect(toMap(
                        key -> (char) key.intValue(),
                        value -> 1,
                        Integer::sum));
        for (char c : new char[]{'A', 'C', 'G', 'T'}) {
            System.out.print(frequencies.getOrDefault(c, 0) + " ");
        }
        System.out.println();
    }
}
