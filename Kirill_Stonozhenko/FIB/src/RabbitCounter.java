import java.math.BigInteger;

public class RabbitCounter {

    private static int months;
    private static BigInteger litter;

    private static BigInteger youngPairsNum = BigInteger.ONE;
    private static BigInteger maturePairsNum = BigInteger.ZERO;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Number of months and degree of reproduction as input arguments were expected");
            return;
        }

        try {
            months = Integer.parseInt(args[0]);
            int litterInt = Integer.parseInt(args[1]);
            if (months <= 0 && litterInt <= 0) {
                throw new NumberFormatException();
            }
            litter = BigInteger.valueOf(litterInt);
        } catch (NumberFormatException e) {
            System.err.println("Two positive integers expected");
            return;
        }

        for (int i = 1; i < months; i++) {
            traceOneMonth();
        }

        System.out.println(youngPairsNum.add(maturePairsNum));
    }

    private static void traceOneMonth() {
        BigInteger totalLitter = maturePairsNum.multiply(litter);
        maturePairsNum = maturePairsNum.add(youngPairsNum);
        youngPairsNum = totalLitter;
    }
}
