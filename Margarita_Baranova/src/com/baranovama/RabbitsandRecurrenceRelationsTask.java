package com.baranovama;

import utils.Utils;

public class RabbitsandRecurrenceRelationsTask {
    private static final String FILEPATH = "src/resources/RabbitsandRecurrenceRelations.txt";

    public static void main(String[] args) throws Exception {
        String[] input = Utils.readFromFile(FILEPATH).get(0).split(" ");
        Integer months = Integer.parseInt(input[0]);
        Integer offspring = Integer.parseInt(input[1]);
        System.out.println(getResult(months, offspring));
    }

    private static long getResult(Integer months, Integer offspring) {
        return months <= 2 ?
                1 :
                getResult(months - 2, offspring) * offspring + getResult(months - 1, offspring);
    }
}
