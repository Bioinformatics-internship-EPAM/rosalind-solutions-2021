package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountingDNANucleotide {

    public static void main(String[] args) throws IOException {
        Helpers.executeStringInput(CountingDNANucleotide::countDNANucleotides);
    }

    public static String countDNANucleotides(final String data) {
        if (data == null) {
            throw new IllegalArgumentException("Argument couldn't be null");
        }

        if (data.length() > 1000) {
            throw new IllegalArgumentException("Maximum data length is 1000");
        }
        final String upperCase = data.toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        for (char nucleotide : upperCase.toCharArray()) {
            switch (nucleotide) {
                case 'A' -> map.merge('A', 1, Integer::sum);
                case 'C' -> map.merge('C', 1, Integer::sum);
                case 'G' -> map.merge('G', 1, Integer::sum);
                case 'T' -> map.merge('T', 1, Integer::sum);
                default -> throw new IllegalArgumentException("Invalid symbol in data " + nucleotide);
            }
        }
        return String.format("%d %d %d %d", map.getOrDefault('A', 0), map.getOrDefault('C', 0),
                             map.getOrDefault('G', 0), map.getOrDefault('T', 0));
    }
}
