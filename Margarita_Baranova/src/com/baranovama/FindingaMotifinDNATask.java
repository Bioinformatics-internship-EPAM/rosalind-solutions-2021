package com.baranovama;

import utils.Utils;

import java.util.StringJoiner;

public class FindingaMotifinDNATask {
    private static final String FILEPATH = "src/resources/FindingaMotifinDNA.txt";

    public static void main(String[] args) throws Exception {
        String dna = Utils.readFromFile(FILEPATH).get(0);
        String dnaSub = Utils.readFromFile(FILEPATH).get(1);
        System.out.println(getResult(dna, dnaSub));
    }

    private static StringJoiner getResult(String dna, String dnaSub) {
       final var result = new StringJoiner(" ");
       Integer index = dna.indexOf(dnaSub);
        while (index >= 0) {
            result.add(Integer.toString(index + 1));
            index = dna.indexOf(dnaSub, index + 1);
        }
       return result;
    }
}
