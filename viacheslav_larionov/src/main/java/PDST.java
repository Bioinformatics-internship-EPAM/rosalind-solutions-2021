import java.util.Arrays;
import java.util.Map;

public class PDST {

    // Creating a Distance Matrix
    public static void main(String[] args) {
        Map<String, String> fastaRecords = Utils.getFastaRecords("cons.txt");

        // Calculate length for each DNA string
        int dnaLength = fastaRecords.values().toArray(String[]::new)[0].length();

        // Create and form p-distance matrix
        Double[][] distanceMatrix = new Double[fastaRecords.size()][fastaRecords.size()];
        String[] dnas = fastaRecords.values().toArray(String[]::new);

        for (int i = 0; i < dnas.length; ++i) {
            distanceMatrix[i][i] = 0.;

            for (int k = i + 1; k < dnas.length; ++k) {
                distanceMatrix[i][k] = distanceMatrix[k][i] =
                            (double) Utils.hammingDistance(dnas[i], dnas[k]) / dnaLength;
            }
        }

        // Print matrix
        for (Double[] row : distanceMatrix) {
            Arrays.stream(row).forEach(value -> System.out.format("%.3f ", value));
            System.out.println();
        }
    }
}
