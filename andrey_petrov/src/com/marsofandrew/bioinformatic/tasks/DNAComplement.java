package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

import java.util.Map;

public class DNAComplement {

    private static final Map<Character, Character> COMPLEMENT_MAP = Map.of(
            'A', 'T',
            'T', 'A',
            'C', 'G',
            'G', 'C');

    public static String complement(final String dna) {
        StringBuilder result = new StringBuilder();
        dna.toUpperCase().chars()
                .mapToObj(c -> (char) c)
                .map(COMPLEMENT_MAP::get)
                .forEachOrdered(result::append);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Helpers.executeStringInput(DNAComplement::complement);
    }
}
