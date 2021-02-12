import org.apache.commons.lang3.tuple.Pair;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.IntStream;

public class PDST {

    private static final String TASK_FILENAME = "cons.txt";

    // Creating a Distance Matrix
    public static void main(String[] args)
            throws IOException, URISyntaxException, SizeLimitExceededException {
        List<Pair<String, String>> fastaRecords = Utils.getFastaRecords(TASK_FILENAME);

        // Collect DNA string and calculate length for each DNA string
        // (we assumed that length of each DNA equals to others)
        String[] dnaStrings = fastaRecords.stream().map(Pair::getValue).toArray(String[]::new);
        int dnaLength = dnaStrings[0].length();

        // Create and form p-distance matrix
        double[][] distanceMatrix = new double[dnaStrings.length][dnaStrings.length];

        for (int i = 0; i < dnaStrings.length; ++i) {
            distanceMatrix[i][i] = 0.;

            for (int k = i + 1; k < dnaStrings.length; ++k) {
                distanceMatrix[i][k] = distanceMatrix[k][i] =
                            (double) Utils.hammingDistance(dnaStrings[i], dnaStrings[k]) / dnaLength;
            }
        }

        // Print matrix
        for (double[] row : distanceMatrix) {
            IntStream.iterate(0, i -> i < row.length, i -> i + 1)
                    .forEach(i -> System.out.format("%.3f"
                            + ((i != row.length - 1) ? " " : "\n"), row[i]));
        }
    }
}
