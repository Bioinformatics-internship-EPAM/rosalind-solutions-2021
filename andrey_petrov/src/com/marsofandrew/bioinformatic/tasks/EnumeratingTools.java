package com.marsofandrew.bioinformatic.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class EnumeratingTools {
    private EnumeratingTools() {
        //not instantiable
    }

    public static <T> Set<List<T>> enumerate(final List<T> elements, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size should be a non-negative number");
        }

        if (size > elements.size()) {
            throw new IllegalArgumentException("size couldn't be larger than elements size");
        }

        if (size == 0) {
            return Collections.emptySet();
        }
        Set<List<T>> result = new HashSet<>();
        elements.forEach(el -> {
            if (size == 1) {
                result.add(new ArrayList<>(List.of(el)));
            } else {
                enumerate(elements, size - 1).forEach(list -> {
                    list.add(el);
                    result.add(list);
                });
            }
        });
        return result;
    }
}
