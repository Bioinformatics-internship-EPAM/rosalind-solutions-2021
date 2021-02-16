package com.marsofandrew.bioinformatic.tasks;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class EnumeratingKmersLexicographically {

    public static Set<String> enumerate(final List<Character> chars, int size) {
        return EnumeratingTools.enumerateCombinations(chars, size)
                .stream()
                .map(list -> list.stream().map(Objects::toString).collect(Collectors.joining()))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            int n = scanner.nextInt();
            List<Character> convertedData =
                    str.chars().mapToObj(c -> (char) c).filter(c -> c != ' ').collect(Collectors.toList());
            enumerate(convertedData, n)
                    .stream()
                    .sorted()
                    .forEachOrdered(System.out::println);
        }
    }
}
