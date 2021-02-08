import java.util.*;

public class BA10C {

    private static String filename = "ba10c.txt";

    // Implement the Viterbi Algorithm
    public static void main(String[] args) {
        // Read HMM from file
        List<Section> sections = new LinkedList<>() {
            {
                add(Section.OUTCOME_SEQUENCE);
                add(Section.OUTCOME_ALPHABET);
                add(Section.STATES);
                add(Section.TRANSITION_MATRIX);
                add(Section.EMISSION_MATRIX);
            }
        };
        HMM hmm = new HMM(filename);
        hmm.readData(sections);

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
        for (int j = 1; j < outcomeSequence.length(); ++j) {
            char symbol = outcomeSequence.charAt(j);

            T1.add(new LinkedList<>());
            T2.add(new LinkedList<>());

            for (int i = 0; i < states.length; ++i) {
                double maxValue = -1;   // max probability value
                int maxIdx = 0;         // state from which

                for (int k = 0; k < states.length; ++k) {
                    double tmp = T1.get(j - 1).get(k)
                            * transitionMatrix.get(states[k].concat(states[i]))
                            * emissionMatrix.get(states[i] + symbol);
                    if (tmp > maxValue) {
                        maxValue = tmp;
                        maxIdx = k;
                    }
                }

                T1.get(j).add(i, maxValue);
                T2.get(j).add(i, maxIdx);
            }
        }

        // Backward: find Viterbi path using founded earlier
        // pointers to most probable states
        int argMaxIdx = 0;
        double maxValue = T1.get(outcomeSequence.length() - 1).get(0);
        for (int i = 1; i < states.length; ++i) {
            double tmp = T1.get(outcomeSequence.length() - 1).get(i);
            if (tmp > maxValue) {
                maxValue = tmp;
                argMaxIdx = i;
            }
        }

        StringBuilder hiddenPath = new StringBuilder(states[argMaxIdx]);

        for (int j = outcomeSequence.length() - 1; j > 0; --j) {
            argMaxIdx = T2.get(j).get(argMaxIdx);
            hiddenPath.insert(0, states[argMaxIdx]);
        }

        System.out.println(hiddenPath);
    }
}
