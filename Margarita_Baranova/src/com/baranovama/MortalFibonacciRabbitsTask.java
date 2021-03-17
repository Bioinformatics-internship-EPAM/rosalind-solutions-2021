package com.baranovama;

import utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class MortalFibonacciRabbitsTask {

    private static final String FILEPATH = "src/resources/MortalFibonacciRabbits.txt";

    public static void main(String[] args) throws Exception {
        String[] input = Utils.readFromFile(FILEPATH).get(0).split(" ");
        Integer months = Integer.parseInt(input[0]);
        Integer lifetime = Integer.parseInt(input[1]);
        System.out.println(getResult(months, lifetime));
    }

    private static BigInteger getResult(Integer months, Integer lifetime) {
        ArrayList<BigInteger> count = new ArrayList();
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < months; i++) {
            if (i < 2) {
                count.add(i, BigInteger.ONE);
            } else if (i < lifetime) {
                count.add(i, (BigInteger) count.get(i - 2).add((BigInteger) count.get(i - 1)));
            } else if (i == lifetime) {
                count.add(i, (BigInteger) count.get(i - 2).add((BigInteger) count.get(i - 1).subtract(BigInteger.ONE)));
            } else {
                count.add(i, (BigInteger) count.get(i - 2).add((BigInteger) count.get(i - 1).subtract((BigInteger) count.get(i - lifetime - 1))));
                count.set(i - lifetime - 1, BigInteger.ZERO);
            }
            result = (BigInteger) count.get(i);
        }
        return result;
    }
}