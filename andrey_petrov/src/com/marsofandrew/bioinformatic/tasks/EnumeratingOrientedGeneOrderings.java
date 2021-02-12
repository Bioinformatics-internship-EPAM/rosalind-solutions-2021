package com.marsofandrew.bioinformatic.tasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnumeratingOrientedGeneOrderings {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            Set<List<Integer>> result = new HashSet<>();
            EnumeratingGeneOrders.count(size)
                    .forEach(list -> {
                        result.addAll(countAllVariants(list));
                    });
            System.out.println(result.size());
            result.forEach(var -> System.out.println(var.stream()
                                                             .map(Objects::toString)
                                                             .collect(Collectors.joining(" "))));
        }
    }

    private static Set<List<Integer>> countAllVariants(final List<Integer> variant) {
        if (variant.isEmpty()) {
            return Collections.emptySet();
        }

        if (variant.size() == 1) {
            return Set.of(List.of(variant.get(0)), List.of(-variant.get(0)));
        }

        var subList = new ArrayList<>(variant);
        subList.remove(0);
        Set<List<Integer>> result = new HashSet<>();
        countAllVariants(subList).forEach(list -> {
            for (int i = -1; i <= 1; i += 2) {
                List<Integer> v = new ArrayList<>();
                v.add(variant.get(0) * i);
                v.addAll(list);
                result.add(v);
            }
        });
        return result;
    }
}
