package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

public class DnaToRnaConverter {

    public static void main(String[] args) {
        Helpers.executeStringInput(DnaToRnaConverter::convert);
    }

    public static String convert(final String dna) {
        if (dna == null) {
            throw new IllegalArgumentException("Argument couldn't be null");
        }

        if (dna.length() > 1000) {
            throw new IllegalArgumentException("Maximum data length is 1000");
        }
        return dna.toUpperCase().replace('T', 'U');
    }
}
