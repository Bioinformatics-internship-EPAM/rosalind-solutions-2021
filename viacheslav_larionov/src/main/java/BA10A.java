import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BA10A {

    // Probability of a Hidden Path Problem
    public static void main(String[] args) {
        // Read HMM from file
        List<Section> sections = new LinkedList<>() {
            {
                add(Section.HIDDEN_PATH);
                add(Section.STATES);
                add(Section.TRANSITION_MATRIX);
            }
        };
        HMM hmm = new HMM("ba10a.txt");
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
