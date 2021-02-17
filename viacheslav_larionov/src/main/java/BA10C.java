import com.google.common.collect.Table;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.IntStream;

public class BA10C {

    private static final String TASK_FILENAME = "ba10c.txt";

    private static String outcomeSequence;

    private static char[] states;

    private static Table<Character, Character, Double> transitionMatrix;

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
        states = HMM.getCharactersFromLine(lines.get(lineIdx));

        lineIdx += 3;
        transitionMatrix = HMM.readMatrixFromLines(lines.subList(lineIdx, lineIdx + states.length), states);

        lineIdx += states.length + 2;
        emissionMatrix = HMM.readMatrixFromLines(lines.subList(lineIdx, lineIdx + states.length), outcomeAlphabet);
    }

    // Implement the Viterbi Algorithm
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Read HMM from file
        readParametersOfHMMFromFile();

        // Implementation of the Viterbi algorithm:
        // 1. declare most probable states numbers (A-0, B-1, ...) which have
        //    greater probability to generate another outcome path symbol
        int[][] mstPrbStates = new int[outcomeSequence.length()][states.length];
        // probabilities of this states
        double[][] mstPrbStatesProbabilities = new double[outcomeSequence.length()][states.length];

        // 2. Init probabilities
        double initProb = 1. / states.length;
        for (int i = 0; i < states.length; ++i) {
            mstPrbStates[0][i] = i;
            mstPrbStatesProbabilities[0][i] = initProb
                    * emissionMatrix.get(states[i], outcomeSequence.charAt(0));
        }

        // 3. Count probabilities sequence
        for (int j = 1; j < outcomeSequence.length(); ++j) {
            char symbol = outcomeSequence.charAt(j);

            int finalJ = j;
            IntStream.range(0, states.length).forEach(i -> {
                Pair<Integer, Double> newStep = IntStream.range(0, states.length).boxed()
                        .map(k -> ImmutablePair.of(k, mstPrbStatesProbabilities[finalJ - 1][k]
                                * transitionMatrix.get(states[k], states[i])
                                * emissionMatrix.get(states[i], symbol)))
                        .max(Comparator.comparingDouble(Pair::getValue))
                        .orElseThrow(NoSuchElementException::new);

                mstPrbStatesProbabilities[finalJ][i] = newStep.getValue();
                mstPrbStates[finalJ][i] = newStep.getKey();
            });
        }

        // 4. Backward: find Viterbi path using founded earlier
        // pointers to most probable states
        int argMaxIdx = IntStream.range(0, states.length)
                .boxed()
                .max(Comparator.comparingDouble(i ->
                        mstPrbStatesProbabilities[outcomeSequence.length() - 1][i]))
                .orElseThrow(NoSuchElementException::new);

        StringBuilder hiddenPath = new StringBuilder("" + states[argMaxIdx]);

        for (int j = outcomeSequence.length() - 1; j > 0; --j) {
            argMaxIdx = mstPrbStates[j][argMaxIdx];
            hiddenPath.insert(0, states[argMaxIdx]);
        }

        System.out.println(hiddenPath);
    }
}
