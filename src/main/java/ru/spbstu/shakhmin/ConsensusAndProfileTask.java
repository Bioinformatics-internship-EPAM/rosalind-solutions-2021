package ru.spbstu.shakhmin;

import com.google.common.base.Joiner;
import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static ru.spbstu.shakhmin.utils.RosalindUtils.FASTA_LABEL;

public final class ConsensusAndProfileTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "consensus_and_profile_task.txt";

    private static Map<String, List<Integer>> buildProfile(final List<String> dataset) {
        final var profile = new TreeMap<String, List<Integer>>();
        var dnaString = new StringBuilder();
        var line = dataset.get(1);
        for (int i = 1; i <= dataset.size(); i++) {
            if (i == dataset.size() || line.startsWith(FASTA_LABEL)) {
                final var dnaLength = dnaString.length();
                for (int j = 0; j < dnaLength; j++) {
                    final var index = j;
                    profile.compute(
                            String.valueOf(dnaString.charAt(index)),
                            (dnaSymbol, frequencies) -> {
                                if (frequencies == null) {
                                    frequencies = new ArrayList<>(Collections.nCopies(dnaLength, 0));
                                }
                                frequencies.set(index, frequencies.get(index) + 1);
                                return frequencies;
                            });
                }
                dnaString = new StringBuilder();
            } else {
                dnaString.append(line);
            }
            if (i + 1 < dataset.size()) {
                line = dataset.get(i + 1);
            }
        }
        return profile;
    }

    private static String buildConsensus(final Map<String, List<Integer>> profile) {
        final var dnaLength = profile.get(RosalindUtils.DNASymbol.A.toString()).size();
        final var consensus = new StringBuilder();
        for (int i = 0; i < dnaLength; i++) {
            String mostCommonSymbol = "";
            int maxFreq = 0;
            for (final var profileEntry : profile.entrySet()) {
                final var currentFreq = profileEntry.getValue().get(i);
                if (currentFreq > maxFreq) {
                    maxFreq = currentFreq;
                    mostCommonSymbol = profileEntry.getKey();
                }
            }
            consensus.append(mostCommonSymbol);
        }
        return consensus.toString();
    }

    @Override
    public String resolve(final List<String> dataset) {
        final var profile = buildProfile(dataset);
        final var consensus = buildConsensus(profile);
        final var answer = new StringBuilder(consensus).append("\n");
        for (final var profileEntry : profile.entrySet()) {
            answer.append(profileEntry.getKey())
                    .append(": ")
                    .append(Joiner.on(" ").join(profileEntry.getValue()))
                    .append("\n");
        }
        return answer.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ConsensusAndProfileTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
