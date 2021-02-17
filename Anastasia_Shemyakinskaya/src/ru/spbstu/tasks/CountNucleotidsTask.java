package ru.spbstu.tasks;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNucleotidsTask {
    private String dnaChain;

    public CountNucleotidsTask(String dnaChain) {
        this.dnaChain = dnaChain;
    }

    public Map<Character, Long> countNucleotides() {
        return dnaChain.chars()
                .boxed()
                .map(c -> ((char) c.intValue()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
