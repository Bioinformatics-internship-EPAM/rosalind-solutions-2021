package PPER;

import utils.Utils;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class PPER {
    private static final String FILE_NAME = "pper_input.txt";
    private static final String FILE_PATH = "src/PPER/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf(Utils.readFromFile(FILE_PATH).get(0));
        int k = Integer.valueOf(Utils.readFromFile(FILE_PATH).get(1));

        System.out.println(PPER.numberPartialPermutations(n, k));
    }

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
