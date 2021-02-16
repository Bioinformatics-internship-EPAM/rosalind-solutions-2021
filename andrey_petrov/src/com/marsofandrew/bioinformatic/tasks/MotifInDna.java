package com.marsofandrew.bioinformatic.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotifInDna {

    public static List<Integer> count(final String dna, final String subDna) {
        if (dna.length() < subDna.length()) {
            throw new IllegalArgumentException("subDNA couldn't be larger than DNA");
        }

        String upperDna = dna.toUpperCase();
        final String subDnaUpper = subDna.toUpperCase();

        List<Integer> matchIndexes = new ArrayList<>();
        int index = 0;
        while (upperDna.contains(subDnaUpper)) {
            int currentIndex = upperDna.indexOf(subDnaUpper) + 1;
            index += currentIndex;
            matchIndexes.add(index);
            upperDna = upperDna.substring(currentIndex);
        }
        return matchIndexes;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String dna = scanner.nextLine();
            final String subDna = scanner.nextLine();
            count(dna, subDna).forEach(pos -> System.out.printf("%d ", pos));
            System.out.println();
        }
    }
}
