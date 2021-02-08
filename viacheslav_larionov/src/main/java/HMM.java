import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

enum Section {
    HIDDEN_PATH,
    OUTCOME_SEQUENCE,
    STATES,
    OUTCOME_ALPHABET,
    TRANSITION_MATRIX,
    EMISSION_MATRIX;
}

public class HMM {

    private String filename;

    private String outcomeSequence;

    private String[] outcomeAlphabet;

    private String hiddenPath;

    private String[] states;

    private HashMap<String, Double> transitionMatrix;

    private HashMap<String, Double> emissionMatrix;

    public HMM (final String filename) {
        this.filename = filename;
    }

    public void readData(final List<Section> sections) {
        ClassLoader classLoader = Utils.class.getClassLoader();
        List<String> lines = new LinkedList<>();

        try (InputStream rd = classLoader.getResourceAsStream(filename);
             InputStreamReader inp = new InputStreamReader(Objects.requireNonNull(rd));
             BufferedReader reader = new BufferedReader(inp)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int lineIdx = 0;
        for (int i = 0; i < sections.size(); ++i) {
            switch (sections.get(i)) {
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
                    if (transitionMatrix == null)
                        transitionMatrix = new HashMap<>();
                    else
                        transitionMatrix.clear();

                    // Skipping states
                    lineIdx += 1;

                    while (lineIdx != lines.size() &&
                            !lines.get(lineIdx).contains("-")) {
                        String[] tokens = lines.get(lineIdx++).split("\\s+");
                        IntStream.range(1, tokens.length)
                                .forEach(k -> transitionMatrix
                                        .put(tokens[0].concat(states[k - 1]), Double.parseDouble(tokens[k])));
                    }
                    break;

                case EMISSION_MATRIX:
                    if (emissionMatrix == null)
                        emissionMatrix = new HashMap<>();
                    else
                        emissionMatrix.clear();

                    // Skipping alphabet
                    lineIdx += 1;

                    while (lineIdx != lines.size() &&
                            !lines.get(lineIdx).contains("-")) {
                        String[] tokens = lines.get(lineIdx++).split("\\s+");
                        IntStream.range(1, tokens.length)
                                .forEach(k -> emissionMatrix
                                        .put(tokens[0].concat(outcomeAlphabet[k - 1]), Double.parseDouble(tokens[k])));
                    }
                    break;
            }

            // Skipping delimiter
            if (sections.get(i) == Section.TRANSITION_MATRIX ||
                    sections.get(i) == Section.EMISSION_MATRIX)
                ++lineIdx;
            else
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

    public HashMap<String, Double> getTransitionMatrix() {
        return transitionMatrix;
    }

    public HashMap<String, Double> getEmissionMatrix() {
        return emissionMatrix;
    }
}
