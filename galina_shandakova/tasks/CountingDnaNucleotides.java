package tasks;

import java.util.Map;
import java.util.stream.Collectors;

//Link : http://rosalind.info/problems/dna/
public class CountingDnaNucleotides {
    public static void countFromString(String dna) {
        if (dna.isEmpty()) {
            return;
        }
        Map<Character, Long> frequencies = dna.chars().boxed().collect(Collectors.groupingBy(
                c -> (char) c.intValue(),
                Collectors.counting()
        ));
        for (char c : new char[]{'A', 'C', 'G', 'T'}) {
            System.out.print(frequencies.getOrDefault(c, 0L) + " ");
        }
        System.out.println();
    }
}
