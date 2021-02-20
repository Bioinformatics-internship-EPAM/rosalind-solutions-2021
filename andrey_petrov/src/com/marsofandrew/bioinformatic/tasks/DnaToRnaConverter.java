package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

public class DnaToRnaConverter {

    public static void main(String[] args) {
        Helpers.executeStringInput(DnaToRnaConverter::convert);
    }

    public static String convert(final String dna) {
        return dna.toUpperCase().replace('T', 'U');
    }
}
