package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class ProteinMass {
    private static final Map<Character, Double> MASS_TABLE = new HashMap<>() {
        {
            put('A', 71.03711);
            put('C', 103.00919);
            put('D', 115.02694);
            put('E', 129.04259);
            put('F', 147.06841);
            put('G', 57.02146);
            put('H', 137.05891);
            put('I', 113.08406);
            put('K', 128.09496);
            put('L', 113.08406);
            put('M', 131.04049);
            put('N', 114.04293);
            put('P', 97.05276);
            put('Q', 128.05858);
            put('R', 156.10111);
            put('S', 87.03203);
            put('T', 101.04768);
            put('V', 99.06841);
            put('W', 186.07931);
            put('Y', 163.06333);
        }
    };

    public static double count(final String proteins) {
        return proteins.chars()
                .mapToObj(c -> (char) c)
                .mapToDouble(MASS_TABLE::get)
                .sum();
    }

    public static void main(String[] args) {
        Helpers.executeStringInput(ProteinMass::count, Objects::toString);
    }
}