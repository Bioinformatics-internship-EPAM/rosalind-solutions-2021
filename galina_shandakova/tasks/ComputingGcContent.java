package tasks;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

//Link: http://rosalind.info/problems/gc/
public class ComputingGcContent {
    public static String findHighestGcContent(Map<String, String> dna) {
        Optional<Map.Entry<String, String>> max = dna.entrySet().stream().max(
                Comparator.comparingDouble(entry -> computeGCContent(entry.getValue()))
        );
        return max.map(stringStringEntry -> stringStringEntry.getKey() +
                "\n" + computeGCContent(stringStringEntry.getValue()) * 100)
                .orElse("");
    }

    private static double computeGCContent(String dna) {
        return (double) dna.replaceAll("[AT]", "").length() / dna.length();
    }
}
