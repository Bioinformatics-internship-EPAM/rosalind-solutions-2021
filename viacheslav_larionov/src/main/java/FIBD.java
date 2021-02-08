import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FIBD {

    private static String filename = "fibd.txt";

    public static Integer[] getMethodParameters(final String filename) {
        ClassLoader classLoader = FIBD.class.getClassLoader();
        List<String> params = new LinkedList<>();

        try (InputStream rd = classLoader.getResourceAsStream(filename);
             InputStreamReader inp = new InputStreamReader(Objects.requireNonNull(rd));
             BufferedReader reader = new BufferedReader(inp)) {
            String line;
            if ((line = reader.readLine()) != null) {
                params.addAll(Arrays.stream(line.split("\\s+"))
                        .collect(Collectors.toList()));
            } else {
                throw new Exception("No Mortal Fibonacci Rabbits parameters in file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return params.stream().map(Integer::parseInt).toArray(Integer[]::new);
    }

    // Mortal Fibonacci Rabbits
    public static void main(String[] args) {
        Integer[] params = getMethodParameters(filename);

        if (params.length == 2
                && (params[0] <= 100 && params[1] <= 20)) {
            int all_months = params[0];
            int life_months = params[1];

            BigInteger[] generation = new BigInteger[all_months];
            generation[0] = BigInteger.valueOf(1);
            generation[1] = generation[0];

            for (int i = 2; i < all_months; ++i) {
                BigInteger tmp = generation[i - 1].add(generation[i - 2]);

                if (i == params[1]) {
                    tmp = tmp.subtract(BigInteger.valueOf(1));
                } else if (i > params[1]) {
                    tmp = tmp.subtract(generation[i - life_months - 1]);
                }

                generation[i] = tmp;
            }

            System.out.println(generation[all_months - 1]);
        }
    }
}
