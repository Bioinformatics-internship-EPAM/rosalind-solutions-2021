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

    private static final String DATASET_FILE_NAME = "consensus_and_profile.txt";

    private static void updateFreqOfDNASymbol(final Map<String, List<Integer>> profile,
                                              final StringBuilder dnaString,
                                              final int position) {
        profile.compute(
                String.valueOf(dnaString.charAt(position)),
                (dnaSymbol, frequencies) -> {
                    if (frequencies == null) {
                        frequencies = new ArrayList<>(Collections.nCopies(dnaString.length(), 0));
                    }
                    frequencies.set(position, frequencies.get(position) + 1);
                    return frequencies;
                });
    }

    private static Map<String, List<Integer>> buildProfile(final List<String> dataset) {
        final var profile = new TreeMap<String, List<Integer>>();
        var dnaString = new StringBuilder();
        var line = dataset.get(1);
        for (int i = 1; i <= dataset.size(); i++) {
            if (i == dataset.size() || line.startsWith(FASTA_LABEL)) {
                for (int j = 0; j < dnaString.length(); j++) {
                    updateFreqOfDNASymbol(profile, dnaString, j);
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
            var mostCommonSymbol = "";
            var maxFreq = 0;
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
        final var consensusAndProfile = new StringBuilder(consensus).append("\n");
        for (final var profileEntry : profile.entrySet()) {
            consensusAndProfile.append(profileEntry.getKey())
                    .append(": ")
                    .append(Joiner.on(" ").join(profileEntry.getValue()))
                    .append("\n");
        }
        return consensusAndProfile.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ConsensusAndProfileTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
