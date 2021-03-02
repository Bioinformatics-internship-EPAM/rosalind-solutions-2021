package com.company.Problems;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class PPER {
    public static BigInteger numberPartialPermutations(int n, int k) {
        BigInteger perm = (factorial(n).divide(factorial(n - k)));
        return perm.remainder(new BigInteger("1000000"));
    }

    public static BigInteger factorial(int n) {
        if (n < 2)
            return BigInteger.valueOf(1);
        else
            return IntStream.rangeClosed(2, n).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }
}
