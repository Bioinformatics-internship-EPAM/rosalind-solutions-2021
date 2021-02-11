package com.marsofandrew.bioinformatic.tasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnumeratingGeneOrders {

    public static Set<List<Integer>> count(int n) {
        if (n > 7 || n < 1) {
            throw new IllegalArgumentException("n should be less than 8 and positive");
        }

        return getPermutations(IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList()));

    }

    private static Set<List<Integer>> getPermutations(final List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptySet();
        }
        Set<List<Integer>> results = new HashSet<>();
        results.add(list);

        list.forEach(el -> {
            var subList = new ArrayList<>(list);
            subList.remove(el);
            var subResult = getPermutations(subList).stream()
                    .peek(list1 -> list1.add(el))
                    .collect(Collectors.toSet());
            results.addAll(subResult);
        });
        return results;
    }

    public static void main(String[] args) {
        int n = -1;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
        }
        if (n < 0) {
            System.err.println("Couldn't read a number, or it is not positive");
            return;
        }
        final Set<List<Integer>> permutations = count(n);
        System.out.println(permutations.size());
        permutations.forEach(var -> System.out.println(var.stream()
                                                               .map(Objects::toString)
                                                               .collect(Collectors.joining(" "))));
    }
}
