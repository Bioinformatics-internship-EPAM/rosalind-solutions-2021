package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountingDNANucleotide {
    private static final Set<Character> NUCLEOTIDES = Set.of('A', 'T', 'G', 'C');

    public static void main(String[] args) {
        Helpers.executeStringInput(CountingDNANucleotide::countDNANucleotides);
    }

    public static String countDNANucleotides(final String data) {
        Map<Character, Integer> map = new HashMap<>();
        for (int charIndex = 0; charIndex < data.length(); charIndex++) {
            char upperCase = Character.toUpperCase(data.charAt(charIndex));
            if (!NUCLEOTIDES.contains(upperCase)) {
                throw new IllegalArgumentException("Invalid symbol in data " + data.charAt(charIndex));
            }
            map.merge(upperCase, 1, Integer::sum);
        }
        return String.format("%d %d %d %d", map.getOrDefault('A', 0), map.getOrDefault('C', 0),
                             map.getOrDefault('G', 0), map.getOrDefault('T', 0));
    }
}
