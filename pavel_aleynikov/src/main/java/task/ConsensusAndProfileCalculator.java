package task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Consensus and Profile
 * <p>
 * http://rosalind.info/problems/cons/
 */
public class ConsensusAndProfileCalculator {

    /**
     * Calculate Profile Matrix from DNA matrix
     *
     * @param dnaSequences - list of DNA matrix row. Row present as String contains chars: {'A', 'C', 'G', 'T'}
     * @return - list of Profile Matrix column. Column present as Map with key: {'A', 'C', 'G', 'T'}
     */
    public static List<Map<Character, Integer>> calculateProfileMatrix(List<String> dnaSequences) {
        if (dnaSequences.isEmpty()) {
            throw new IllegalArgumentException("Illegal sequence count");
        }
        int sequenceLength = dnaSequences.get(0).length();
        if (!dnaSequences.stream().allMatch(x -> x.length() == sequenceLength)) {
            throw new IllegalArgumentException("Sequences must be the same length");
        }
        List<Map<Character, Integer>> result = new ArrayList<>(sequenceLength);
        for (int i = 0; i < sequenceLength; i++) {
            int finalI = i;
            Map<Character, Integer> column = dnaSequences.stream().map(dna -> dna.charAt(finalI))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));
            column.putIfAbsent('A', 0);
            column.putIfAbsent('C', 0);
            column.putIfAbsent('G', 0);
            column.putIfAbsent('T', 0);
            result.add(column);
        }
        return result;
    }

    /**
     * Calculate consensus string from Profile Matrix
     * <p>
     * Method can receive a matrix from: {@link ConsensusAndProfileCalculator#calculateProfileMatrix}
     *
     * @param profileMatrix - list of Profile Matrix column. Column present as Map with key: {'A', 'C', 'G', 'T'}
     * @return - string contains chars: {'A', 'C', 'G', 'T'}
     */
    public static String calculateConsensus(List<Map<Character, Integer>> profileMatrix) {
        StringBuilder result = new StringBuilder();
        for (Map<Character, Integer> column : profileMatrix) {
            result.append(column.entrySet().stream()
                    .max(Comparator.comparingInt(Map.Entry::getValue))
                    .get().getKey());
        }
        return result.toString();
    }

}
