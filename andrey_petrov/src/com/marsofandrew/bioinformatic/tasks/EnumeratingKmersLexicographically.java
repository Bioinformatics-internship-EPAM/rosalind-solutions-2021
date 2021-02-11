package com.marsofandrew.bioinformatic.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class EnumeratingKmersLexicographically {

    public static Set<String> enumerate(final List<Character> chars, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size should be a non-negative number");
        }

        if (size > chars.size()) {
            throw new IllegalArgumentException("size couldn't be larger than chars size");
        }

        if (size == 0) {
            return Collections.emptySet();
        }
        Set<String> result = new HashSet<>();
        chars.forEach(character -> {
            if (size == 1) {
                result.add(character.toString());
            } else {
                enumerate(chars, size - 1).forEach(str -> {
                    result.add(character + str);
                });
            }
        });
        return result;
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
