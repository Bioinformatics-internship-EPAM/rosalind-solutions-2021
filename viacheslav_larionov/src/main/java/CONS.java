import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.IntStream;

public class CONS {

    private static final String TASK_FILENAME = "cons.txt";

    // Consensus and Profile
    public static void main(String[] args)
            throws SizeLimitExceededException, IOException, URISyntaxException {
        List<Pair<String, String>> fastaRecords = Utils.getFastaRecords(TASK_FILENAME);

        // Assumed that all DNAs in file have equal length
        int dnaLength = fastaRecords.get(0).getValue().length();

        // Initialize profile matrix
        Map<Character, int[]> nucleobasesMap = new LinkedHashMap<>() {
            {
                put('A', new int[dnaLength]);
                put('C', new int[dnaLength]);
                put('G', new int[dnaLength]);
                put('T', new int[dnaLength]);
            }
        };

        // Form profile matrix
        for (Pair<String, String> record : fastaRecords) {
            String dnaString = record.getValue();
            for (int k = 0; k < dnaLength; ++k) {
                nucleobasesMap.get(dnaString.charAt(k))[k] += 1;
            }
        }

        // Find one of the consensus strings
        StringBuilder consensusStr = new StringBuilder();
        IntStream.range(0, dnaLength).forEach(i -> {
            nucleobasesMap.entrySet().stream()
                    .map(pair -> ImmutablePair.of(pair.getKey(), pair.getValue()[i]))
                    .max(Comparator.comparingInt(Pair::getValue))
                    .ifPresent(pair -> consensusStr.append(pair.getKey()));
        });

        // Print consensus string and profile matrix
        System.out.println(consensusStr);
        nucleobasesMap.forEach((k, v) ->
            System.out.format("%c: %s\n", k, StringUtils.join(ArrayUtils.toObject(v), " ")));
    }
}
