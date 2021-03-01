import com.google.common.collect.Table;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.IntStream;

public class BA10A {

    private static final String TASK_FILENAME = "ba10a.txt";

    private static String hiddenPath;

    private static char[] states;
    
    private static Table<Character, Character, Double> transitionMatrix;

    private static void readParametersOfHMMFromFile()
            throws IOException, URISyntaxException {
        List<String> lines = Utils.readLinesFromFile(TASK_FILENAME);

        // Get HMM parameters
        int lineIdx = 0;
        hiddenPath = lines.get(lineIdx);

        lineIdx += 2;
        states = HMM.getCharactersFromLine(lines.get(lineIdx));

        lineIdx += 3;
        transitionMatrix = HMM.readMatrixFromLines(lines.subList(lineIdx, lineIdx + states.length), states);
    }

    // Probability of a Hidden Path Problem
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Read HMM parameters from file
        readParametersOfHMMFromFile();

        // Initial probabilities for each state are equal
        double prob = 1. / states.length;
        // Calculate probability of the hidden path
        prob *= IntStream.range(0, hiddenPath.length() - 1)
                .mapToDouble(i -> transitionMatrix.get(hiddenPath.charAt(i), hiddenPath.charAt(i + 1)))
                .reduce(1, (a, b) -> a * b);

        System.out.println(prob);
    }
}
