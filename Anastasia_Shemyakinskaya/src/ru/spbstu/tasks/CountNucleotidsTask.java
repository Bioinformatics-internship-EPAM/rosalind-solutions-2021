package ru.spbstu.tasks;

import java.util.HashMap;
import java.util.Map;

public class CountNucleotidsTask {
    private String dnaChain;
    private final char[] symbols = {'A', 'C', 'G', 'T'};

    public CountNucleotidsTask(String dnaChain) {
        this.dnaChain = dnaChain;
    }

    public Map<Character, Long> countNucleotides() {
        Map<Character, Long> map = new HashMap<>();
        for (char symbol : symbols) {
            map.put(symbol, countNucleotides(symbol));
        }
        return map;
    }

    private Long countNucleotides(char symbol) {
        return dnaChain.chars().filter(c -> c == symbol).count();
    }
}
