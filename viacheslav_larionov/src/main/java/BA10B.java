import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class BA10B {

    private static final String TASK_FILENAME = "ba10b.txt";

    // Compute the Probability of an Outcome Given a Hidden Path
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Read HMM from file
        List<Section> sections = List.of(
                Section.OUTCOME_SEQUENCE,
                Section.OUTCOME_ALPHABET,
                Section.HIDDEN_PATH,
                Section.STATES,
                Section.EMISSION_MATRIX
        );
        HMM hmm = new HMM();
        hmm.readDataFromFile(TASK_FILENAME, sections);

        // Get HMM parameters
        String outcomeSequence = hmm.getOutcomeSequence();
        String hiddenPath = hmm.getHiddenPath();
        Map<String, Double> emissionMatrix = hmm.getEmissionMatrix();

        double prob = 1;
        for (int i = 0; i < hiddenPath.length(); ++i) {
            prob *= emissionMatrix.get("" + hiddenPath.charAt(i) + outcomeSequence.charAt(i));
        }

        System.out.println(prob);
    }
}
