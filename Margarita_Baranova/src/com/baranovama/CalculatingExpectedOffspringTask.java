package com.baranovama;

import utils.Utils;

import java.util.stream.IntStream;

public class CalculatingExpectedOffspringTask {

    private static final String FILEPATH = "src/resources/CalculatingExpectedOffspring.txt";

    public static void main(String[] args) throws Exception {
        String[] input = Utils.readFromFile(FILEPATH).get(0).split(" ");
        System.out.println(getResult(input));
    }

    private static String getResult(String[] input) {
        //Probability in pairs AA+AA, AA+Aa, AA+aa, Aa+Aa, Aa+aa, aa+aa
        double[] chances = new double [] {1, 1, 1, 0.75, 0.5, 0};
        final double result = IntStream.range(0, chances.length).mapToDouble(i ->
                chances[i] * Integer.parseInt(input[i])).sum();
        return String.format("%.1f", 2*result).replace(',', '.');
    }
}
