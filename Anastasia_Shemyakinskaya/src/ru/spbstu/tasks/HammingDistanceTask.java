package ru.spbstu.tasks;

import java.util.stream.IntStream;

public class HammingDistanceTask {

    private String dna1;
    private String dna2;

    public HammingDistanceTask(String dna1, String dna2) {
        this.dna1 = dna1;
        this.dna2 = dna2;
    }

    public Long evaluateHammingDistance() {
        if (dna2.length() != dna1.length()) {
            throw new IllegalArgumentException("Strings are not equals");
        }
        return IntStream.range(0, dna1.length()).filter(i -> dna1.charAt(i)!=dna2.charAt(i)).count();
    }
}
