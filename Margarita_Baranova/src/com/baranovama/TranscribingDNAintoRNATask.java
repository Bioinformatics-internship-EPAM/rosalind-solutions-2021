package com.baranovama;

import utils.Utils;

public class TranscribingDNAintoRNATask {
    private static final String FILEPATH= "src/resources/TranscribingDNAintoRNA.txt";

    public static void main(String[] args) throws Exception {
        String input = Utils.readFromFile(FILEPATH).get(0);
        System.out.println(getResult(input));
    }

    private static String getResult(String input) {
        return input.replace('T', 'U');
    }
}
