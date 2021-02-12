import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class FIBD {

    private static final String TASK_FILENAME = "fibd.txt";

    public static int[] getMethodParameters(final String filename)
            throws IOException, URISyntaxException, SizeLimitExceededException {
        List<String> lines = Utils.readLinesFromFile(filename);
        if (lines.size() != 1)
            throw new SizeLimitExceededException("Must be only one parameters string in file");
        int[] params = Arrays.stream(lines.get(0).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (params.length != 2) {
            throw new SizeLimitExceededException("Must be only 2 parameters:" +
                    " months count and life months count");
        } else if (params[0] > 100 || params[1] > 20) {
            throw new IllegalArgumentException("Months count must be <= 100" +
                    " and rabbits life months count must be <= 20");
        }

        return params;
    }

    // Mortal Fibonacci Rabbits
    public static void main(String[] args)
            throws IOException, URISyntaxException, SizeLimitExceededException {
        int[] params = getMethodParameters(TASK_FILENAME);
        int monthsCount = params[0];
        int lifeMonthsCount = params[1];

        if (monthsCount == 0 || lifeMonthsCount == 0) {
            throw new IllegalArgumentException("Minimal months count = 1," +
                    " minimal rabbits life months count = 1");
        } else if (monthsCount == 1) {
            System.out.println(1);
        } else if (lifeMonthsCount == 1) {
            System.out.println(0);
        } else {
            BigInteger[] generation = new BigInteger[monthsCount];
            generation[0] = BigInteger.valueOf(1);
            generation[1] = generation[0];

            for (int i = 2; i < monthsCount; ++i) {
                BigInteger tmp = generation[i - 1].add(generation[i - 2]);

                if (i == lifeMonthsCount) {
                    tmp = tmp.subtract(BigInteger.valueOf(1));
                } else if (i > lifeMonthsCount) {
                    tmp = tmp.subtract(generation[i - lifeMonthsCount - 1]);
                }

                generation[i] = tmp;
            }

            System.out.println(generation[monthsCount - 1]);
        }
    }
}
