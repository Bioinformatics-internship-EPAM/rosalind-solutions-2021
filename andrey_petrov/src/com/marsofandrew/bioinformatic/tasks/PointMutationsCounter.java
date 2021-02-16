package com.marsofandrew.bioinformatic.tasks;

import java.util.Scanner;

public class PointMutationsCounter {

    public static int count(final String dna1, final String dna2) {
        if (dna1.length() != dna2.length()) {
            throw new IllegalArgumentException("Strings should have the same length");
        }
        final String dna1Upper = dna1.toUpperCase();
        final String dna2Upper = dna2.toUpperCase();

        int accumulator = 0;
        for (int i = 0; i < dna1.length(); i++) {
            if (dna1Upper.charAt(i) != dna2Upper.charAt(i)) {
                accumulator++;
            }
        }
        return accumulator;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String dna1 = scanner.nextLine();
            final String dna2 = scanner.nextLine();
            System.out.println(count(dna1, dna2));
        }
    }
}
