package com.marsofandrew.bioinformatic.tasks;

import com.marsofandrew.bioinformatic.common.Helpers;

import java.util.*;
import java.util.stream.Collectors;

public class EnumeratingKmersLexicographically {

    public static Set<String> enumerate(final List<Character> chars, int size) {
        return EnumeratingTools.enumerate(chars, size)
                .stream()
                .map(list -> list.stream().map(Objects::toString).collect(Collectors.joining()))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            int n = scanner.nextInt();
            enumerate(str.chars().mapToObj(c -> (char) c).filter(c -> c != ' ').collect(Collectors.toList()), n)
                    .stream()
                    .sorted()
                    .forEachOrdered(System.out::println);
        }
    }
}
