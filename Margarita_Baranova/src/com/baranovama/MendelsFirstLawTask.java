package com.baranovama;

import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class MendelsFirstLawTask {
    private static final String FILEPATH = "src/resources/MendelsFirstLaw.txt";

    public static void main(String[] args) throws Exception {
        String[] input = Utils.readFromFile(FILEPATH).get(0).split(" ");
        System.out.println(getResult(input));
    }

    private static String getResult(String[] input) {

        Map<String, Object> counts = Map.of(
                "AA", Integer.parseInt(input[0]),
                "Aa", Integer.parseInt(input[1]),
                "aa", Integer.parseInt(input[2])
        );

        var count = (int) counts.get("AA") + (int) counts.get("Aa") + (int) counts.get("aa");

        float allVariants = count*(count - 1)/2;

        float probability = 0;
        probability += 1 * (((int) counts.get("AA") * ((int) counts.get("AA") - 1)) / 2) / allVariants; //AA+AA
        probability += 1 * (int) counts.get("AA") * (int) counts.get("Aa") /allVariants; //AA+Aa
        probability += 1 * (int) counts.get("AA") * (int) counts.get("aa") /allVariants; //AA+aa
        probability += 0.75f * ((int) counts.get("Aa") * ((int) counts.get("Aa") - 1) / 2) / allVariants; //Aa+Aa
        probability += 0.5f *(int) counts.get("Aa")*(int) counts.get("aa")/allVariants; //Aa+aa

        final String result = String.format("%.5f", probability);
        return result.replace(',', '.');
    }
}
