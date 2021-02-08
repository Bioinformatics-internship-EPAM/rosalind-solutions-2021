import java.util.*;

public class BA10B {

    // Compute the Probability of an Outcome Given a Hidden Path
    public static void main(String[] args) {
        // Read HMM from file
        List<Section> sections = new LinkedList<>() {
            {
                add(Section.OUTCOME_SEQUENCE);
                add(Section.OUTCOME_ALPHABET);
                add(Section.HIDDEN_PATH);
                add(Section.STATES);
                add(Section.EMISSION_MATRIX);
            }
        };
        HMM hmm = new HMM("ba10b.txt");
        hmm.readData(sections);

        // Get HMM parameters
        String outcomeSequence = hmm.getOutcome();
        String hiddenPath = hmm.getHiddenPath();
        Map<String, Double> emissionMatrix = hmm.getEmissionMatrix();

        double prob = 1;
        for (int i = 0; i < hiddenPath.length(); ++i) {
            prob *= emissionMatrix.get("" + hiddenPath.charAt(i) + outcomeSequence.charAt(i));
        }

        System.out.println(prob);
    }
}
