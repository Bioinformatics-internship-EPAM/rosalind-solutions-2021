import java.util.*;
import java.util.stream.IntStream;

public class CONS {

    // Consensus and Profile
    public static void main(String[] args) {
        HashMap<String, String> fastaRecords = Utils.getFastaRecords("cons.txt");

        // Assumed that all DNAs in file have equal length
        int dnaLength = fastaRecords.values().toArray(String[]::new)[0].length();

        // Initialize profile matrix
        Map<Character, Integer[]> nucleobasesMap = new LinkedHashMap<>() {
            {
                put('A', new Integer[dnaLength]);
                put('C', new Integer[dnaLength]);
                put('G', new Integer[dnaLength]);
                put('T', new Integer[dnaLength]);
            }
        };

        // Form profile matrix
        nucleobasesMap.keySet().forEach(nucleobase ->
                Arrays.fill(nucleobasesMap.get(nucleobase), 0));
        fastaRecords.values().forEach(dna ->
                IntStream.range(0, dnaLength).forEach(k ->
                        nucleobasesMap.get(dna.charAt(k))[k] =
                                (nucleobasesMap.get(dna.charAt(k))[k] != null)
                                        ? nucleobasesMap.get(dna.charAt(k))[k] + 1
                                        : 1));

        // Find one of the consensus strings
        StringBuilder consensusStr = new StringBuilder();
        for (int i = 0; i < dnaLength; ++i) {
            int biggestFrequency = 0;
            int nucleobaseFrequency;
            char mostFoundedNucleobase = ' ';

            for (Character key : nucleobasesMap.keySet()) {
                if ((nucleobaseFrequency = nucleobasesMap.get(key)[i])
                        > biggestFrequency) {
                    biggestFrequency = nucleobaseFrequency;
                    mostFoundedNucleobase = key;
                }
            }
            consensusStr.append(mostFoundedNucleobase);
        }

        // Print consensus string and profile matrix
        System.out.println(consensusStr);
        nucleobasesMap.keySet().forEach(nucleobase -> {
            System.out.format("%c:", nucleobase);
            Arrays.stream(nucleobasesMap.get(nucleobase))
                    .forEach(value -> System.out.format(" %d", value));
            System.out.println();
        });
    }
}
