package com.baranovama;

import utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ComplementingaStrandofDNATask {
    private static final String FILEPATH = "src/resources/ComplementingaStrandofDNA.txt";

    public static void main(String[] args) throws Exception {
        String input = Utils.readFromFile(FILEPATH).get(0);
        System.out.println(getResult(input));
    }

    private static String getResult(String input) {
        var reverseComplement = new StringBuilder();
        Map<Character, Character> map = Map.of(
                'A', 'T',
                'C', 'G',
                'G', 'C',
                'T', 'A'
        );
        IntStream.range(0, input.length()).mapToObj(i -> map.get(input.charAt(i))).forEach(reverseComplement::append);
        final String result = reverseComplement.reverse().toString();
        return result;
    }
}
