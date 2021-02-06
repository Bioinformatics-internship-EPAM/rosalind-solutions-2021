package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

import java.util.Map;

public class DNAComplement {

    private static final Map<Character, Character> COMPLEMENT_MAP =
            Map.of('A', 'T', 'T', 'A', 'C', 'G', 'G', 'C');

    public static String complement(final String dna) {
        Helpers.checkDnaFast(dna);
        return dna.toUpperCase().chars()
                .mapToObj(c -> (char) c)
                .map(COMPLEMENT_MAP::get)
                .collect(StringBuilder::new,
                         StringBuilder::append,
                         (sb1, sb2) -> sb1.append(sb2.toString()))
                .reverse()
                .toString();
    }

    public static void main(String[] args) {
        Helpers.executeStringInput(DNAComplement::complement);
    }
}
