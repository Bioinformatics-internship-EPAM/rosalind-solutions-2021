import com.google.common.collect.Table;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.IntStream;

public class BA10B {

    private static final String TASK_FILENAME = "ba10b.txt";

    private static String outcomeSequence;

    private static String hiddenPath;

    private static Table<Character, Character, Double> emissionMatrix;

    private static void readParametersOfHMMFromFile()
            throws IOException, URISyntaxException {
        List<String> lines = Utils.readLinesFromFile(TASK_FILENAME);

        // Get HMM parameters
        int lineIdx = 0;
        outcomeSequence = lines.get(lineIdx);

        lineIdx += 2;
        char[] outcomeAlphabet = HMM.getCharactersFromLine(lines.get(lineIdx));

        lineIdx += 2;
        hiddenPath = lines.get(lineIdx);

        lineIdx += 2;
        char[] states = HMM.getCharactersFromLine(lines.get(lineIdx));

        lineIdx += 3;
        emissionMatrix = HMM.readMatrixFromLines(lines.subList(lineIdx, lineIdx + states.length), outcomeAlphabet);
    }

    // Compute the Probability of an Outcome Given a Hidden Path
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Read HMM from file
        readParametersOfHMMFromFile();

        double prob = IntStream.range(0, hiddenPath.length())
                .mapToDouble(i -> emissionMatrix.get(hiddenPath.charAt(i), outcomeSequence.charAt(i)))
                .reduce(1, (a, b) -> a * b);

        System.out.println(prob);
    }
}
