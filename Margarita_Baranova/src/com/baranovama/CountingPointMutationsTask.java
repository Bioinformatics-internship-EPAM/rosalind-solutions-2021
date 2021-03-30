package com.baranovama;

import utils.Utils;

import java.util.stream.IntStream;

public class CountingPointMutationsTask {
    private static final String FILEPATH = "src/resources/CountingPointMutations.txt";

    public static void main(String[] args) throws Exception {
        String dna1 = Utils.readFromFile(FILEPATH).get(0);
        String dna2 = Utils.readFromFile(FILEPATH).get(1);
        System.out.println(getResult(dna1, dna2));
    }

    private static String getResult(String dna1, String dna2) {
        long hammingDistance = IntStream.range(0, dna1.length()).filter(i -> dna1.charAt(i) != dna2.charAt(i)).count();
        final String result = Integer.toString((int) hammingDistance);
        return result;
    }
}
