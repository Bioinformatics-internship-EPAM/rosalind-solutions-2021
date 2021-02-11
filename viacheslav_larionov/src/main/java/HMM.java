import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.IntStream;

public class HMM {

    private String filename;

    private String outcomeSequence;

    private String[] outcomeAlphabet;

    private String hiddenPath;

    private String[] states;

    private Map<String, Double> transitionMatrix;

    private Map<String, Double> emissionMatrix;

    public HMM (final String filename) {
        this.filename = filename;
    }

    private static Map<String, Double> readHMMMatrixFromLines(final List<String> lines,
                                                              final String[] alphabetSymbols) {
        Map<String, Double> matrix = new HashMap<>();

        for (String line : lines) {
            String[] tokens = line.split("\\s+");
            IntStream.range(1, tokens.length)
                    .forEach(k -> matrix
                            .put(tokens[0].concat(alphabetSymbols[k - 1]), Double.parseDouble(tokens[k])));
        }

        return matrix;
    }

    public void readData(final List<Section> sections) throws IOException, URISyntaxException {
        List<String> lines = Utils.readLinesFromFile(filename);

        int lineIdx = 0;
        for (Section section : sections) {
            int lastMatrixLineIdx = 0;

            if (section == Section.TRANSITION_MATRIX ||
                    section == Section.EMISSION_MATRIX) {
                lastMatrixLineIdx = lineIdx + 1 + states.length;
            }

            switch (section) {
                case OUTCOME_SEQUENCE:
                    outcomeSequence = lines.get(lineIdx);
                    break;

                case OUTCOME_ALPHABET:
                    outcomeAlphabet = lines.get(lineIdx).split("\\s+");
                    break;

                case HIDDEN_PATH:
                    hiddenPath = lines.get(lineIdx);
                    break;

                case STATES:
                    states = lines.get(lineIdx).split("\\s+");
                    break;

                case TRANSITION_MATRIX:
                    transitionMatrix = readHMMMatrixFromLines(
                            lines.subList(lineIdx + 1, lastMatrixLineIdx),
                            states
                    );
                    break;

                case EMISSION_MATRIX:
                    emissionMatrix = readHMMMatrixFromLines(
                            lines.subList(lineIdx + 1, lastMatrixLineIdx),
                            outcomeAlphabet
                    );
                    break;
            }

            // Add matrix length to the last matrix line
            if (section == Section.TRANSITION_MATRIX ||
                    section == Section.EMISSION_MATRIX)
                lineIdx = lastMatrixLineIdx - 1;
            // Skipping delimiter
            lineIdx += 2;
        }
    }

    public String getOutcomeSequence() {
        return outcomeSequence;
    }

    public String[] getOutcomeAlphabet() {
        return outcomeAlphabet;
    }

    public String getHiddenPath() {
        return hiddenPath;
    }

    public String[] getStates() {
        return states;
    }

    public Map<String, Double> getTransitionMatrix() {
        return transitionMatrix;
    }

    public Map<String, Double> getEmissionMatrix() {
        return emissionMatrix;
    }
}
