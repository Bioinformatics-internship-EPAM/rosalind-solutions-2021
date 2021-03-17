package com.baranovama;

import utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CountingDNANucleotidesTask {
    private static final String FILEPATH= "src/resources/CountingDNANucleotides.txt";

    public static void main(String[] args) throws Exception {
        String input = Utils.readFromFile(FILEPATH).get(0);
        System.out.println(getResult(input));
    }

    private static String getResult(String input){
        var map = new HashMap<Character, Integer>(Map.of(
                'A', 0,
                'C', 0,
                'G', 0,
                'T', 0
        ));
        char[] chars = input.toCharArray();
        IntStream.range(0, chars.length).forEach(i -> {
            if (!map.containsKey(chars[i])) {
                System.out.println("Error");
            }
            map.put(chars[i], map.get(chars[i]) + 1);
        });
        return String.format("%d %d %d %d", map.get('A'), map.get('C'), map.get('G'), map.get('T'));
    }
}
