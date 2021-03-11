package tasks;

import java.math.BigInteger;
import java.util.Arrays;

//Link: http://rosalind.info/problems/fibd/
public class MortalFibonacciRabbits {
    public static BigInteger countBySimulation(int monthsNum, int dieMonths) {
        if (monthsNum <= 0 || dieMonths <= 0) {
            return BigInteger.valueOf(-1);
        }
        BigInteger[] rabbits = new BigInteger[dieMonths];
        Arrays.fill(rabbits, BigInteger.ZERO);
        rabbits[0] = BigInteger.valueOf(1);
        for (int month = 1; month < monthsNum; month++) {
            BigInteger born = Arrays.stream(rabbits).skip(1).reduce(BigInteger::add).orElse(BigInteger.ZERO);
            System.arraycopy(rabbits, 0, rabbits, 1, rabbits.length - 1);
            rabbits[0] = born;
        }
        return Arrays.stream(rabbits).reduce(BigInteger::add).orElse(BigInteger.ZERO);
    }

}
