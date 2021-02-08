import java.math.BigInteger;
import java.util.LinkedList;

public class NotImmortalRabbitCounter {

    private static int months;
    private static int month;
    private static int lifeLength;

    private static LinkedList<BigInteger> youthHistory;
    private static BigInteger youngPairsNum = BigInteger.ONE;
    private static BigInteger maturePairsNum = BigInteger.ZERO;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Number of months and rabbit life length as input arguments were expected");
            return;
        }

        try {
            months = Integer.parseInt(args[0]);
            lifeLength = Integer.parseInt(args[1]);
            if (months <= 0 && lifeLength <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Two positive integers expected");
            return;
        }

        youthHistory = new LinkedList<>();

        for (month = 1; month < months; month++) {
            traceOneMonth();
        }

        System.out.println(youngPairsNum.add(maturePairsNum));
    }

    private static void traceOneMonth() {
        youthHistory.addFirst(youngPairsNum);
        BigInteger totalLitter = maturePairsNum;
        maturePairsNum = maturePairsNum.add(youngPairsNum);
        if (month >= lifeLength) {
            maturePairsNum = maturePairsNum.subtract(youthHistory.pollLast());
        }
        youngPairsNum = totalLitter;
    }
}
