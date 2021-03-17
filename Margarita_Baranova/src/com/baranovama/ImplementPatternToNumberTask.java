package com.baranovama;

import utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ImplementPatternToNumberTask {

    private static final String FILEPATH= "src/resources/ImplementPatternToNumber.txt";

    public static void main(String[] args) throws Exception {
        String input = Utils.readFromFile(FILEPATH).get(0);
        System.out.println(getResult(input));
    }

    private static String getResult(String input){
        var map = new HashMap<Character, Integer>(Map.of(
                'A', 0,
                'C', 1,
                'G', 2,
                'T', 3
        ));
        char[] chars = input.toCharArray();
        long  number = IntStream.range(0, chars.length).mapToLong(i -> (long) (map.get(chars[i]) * (Math.pow(4, chars.length - i - 1)))).sum();
        return String.format("%d", number);
    }
}
