package tasks;

import java.math.BigInteger;

//Link: http://rosalind.info/problems/fib/
public class RabbitsAndRecurrenceRelations {
    public static BigInteger countTotalNumberBySimulation(int months, int fertility) {
        if (months > 0 && fertility > 0) {
            return countTotalNumberRecursive(months, fertility, BigInteger.ZERO,
                    BigInteger.ZERO, BigInteger.ONE, 1);
        } else return BigInteger.valueOf(-1);
    }

    private static BigInteger countTotalNumberRecursive(int months, int fertility,
                                                        BigInteger pregnantNum, BigInteger oneMonthNum,
                                                        BigInteger newbornNum, int numMonths) {
        if (numMonths != months) {
            return countTotalNumberRecursive(months, fertility, pregnantNum.add(oneMonthNum), newbornNum,
                    pregnantNum.add(oneMonthNum).multiply(BigInteger.valueOf(fertility)), numMonths + 1);
        } else {
            return pregnantNum.add(oneMonthNum).add(newbornNum);
        }
    }

}
