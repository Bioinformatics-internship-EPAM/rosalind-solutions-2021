import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BA10A {

    private static final String TASK_FILENAME = "ba10a.txt";

    // Probability of a Hidden Path Problem
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Read HMM from file
        List<Section> sections = Arrays.asList(
                Section.HIDDEN_PATH,
                Section.STATES,
                Section.TRANSITION_MATRIX
        );
        HMM hmm = new HMM(TASK_FILENAME);
        hmm.readData(sections);

        // Get HMM parameters
        String hiddenPath = hmm.getHiddenPath();
        String[] states = hmm.getStates();
        Map<String, Double> transitionMatrix = hmm.getTransitionMatrix();

        // Initial probabilities for each state are equal
        double prob = 1. / states.length;
        // Calculate probability of the hidden path
        for (int i = 0; i < hiddenPath.length() - 1; ++i) {
            prob *= transitionMatrix.get(hiddenPath.substring(i, i + 2));
        }

        System.out.println(prob);
    }
}
