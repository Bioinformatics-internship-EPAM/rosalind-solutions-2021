import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.IntStream;

public class BA10C {

    private static final String TASK_FILENAME = "ba10c.txt";

    // Implement the Viterbi Algorithm
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Read HMM from file
        List<Section> sections = List.of(
                Section.OUTCOME_SEQUENCE,
                Section.OUTCOME_ALPHABET,
                Section.STATES,
                Section.TRANSITION_MATRIX,
                Section.EMISSION_MATRIX
        );
        HMM hmm = new HMM();
        hmm.readDataFromFile(TASK_FILENAME, sections);

        // Get HMM parameters
        String outcomeSequence = hmm.getOutcomeSequence();
        String[] states = hmm.getStates();
        Map<String, Double> transitionMatrix = hmm.getTransitionMatrix();
        Map<String, Double> emissionMatrix = hmm.getEmissionMatrix();

        // Implementation of the Viterbi algorithm
        List<List<Double>> T1 = new LinkedList<>();   // probabilities
        List<List<Integer>> T2 = new LinkedList<>();  // states numbers: A-0, B-1, ...
        T1.add(new LinkedList<>());
        T2.add(new LinkedList<>());

        // Init probabilities
        double initProb = 1. / states.length;
        for (int i = 0; i < states.length; ++i) {
            T1.get(0).add(i, initProb
                    * emissionMatrix.get(states[i] + outcomeSequence.charAt(0)));
            T2.get(0).add(i, 0);
        }

        // Count probabilities sequence
        IntStream.range(1, outcomeSequence.length()).forEach(j -> {
            char symbol = outcomeSequence.charAt(j);
            T1.add(new LinkedList<>());
            T2.add(new LinkedList<>());

            IntStream.range(0, states.length).forEach(i -> {
                Pair<Integer, Double> newStep = IntStream.range(0, states.length).boxed()
                        .map(k -> ImmutablePair.of(k, T1.get(j - 1).get(k)
                                * transitionMatrix.get(states[k].concat(states[i]))
                                * emissionMatrix.get(states[i] + symbol)))
                        .max(Comparator.comparingDouble(Pair::getValue))
                        .orElseThrow(NoSuchElementException::new);

                T1.get(j).add(newStep.getValue());
                T2.get(j).add(newStep.getKey());
            });
        });

        // Backward: find Viterbi path using founded earlier
        // pointers to most probable states
        int argMaxIdx =IntStream.range(0, states.length)
                .boxed()
                .max(Comparator.comparingDouble(i -> T1.get(outcomeSequence.length() - 1).get(i)))
                .orElseThrow(NoSuchElementException::new);

        StringBuilder hiddenPath = new StringBuilder(states[argMaxIdx]);

        for (int j = outcomeSequence.length() - 1; j > 0; --j) {
            argMaxIdx = T2.get(j).get(argMaxIdx);
            hiddenPath.insert(0, states[argMaxIdx]);
        }

        System.out.println(hiddenPath);
    }
}
