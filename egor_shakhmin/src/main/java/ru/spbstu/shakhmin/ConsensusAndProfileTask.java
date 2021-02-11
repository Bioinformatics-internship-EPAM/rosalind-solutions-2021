package ru.spbstu.shakhmin;

import com.google.common.base.Joiner;
import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class ConsensusAndProfileTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "consensus_and_profile.txt";

    @Override
    public String resolve(final List<String> dataset) {
        return new Profile(dataset).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ConsensusAndProfileTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }

    private static final class Profile {
        private final Map<String, List<Integer>> dnaSymbolToFreq;
        private String consensus;

        public Profile(final List<String> dataset) {
            dnaSymbolToFreq = new TreeMap<>();
            var dnaLength = 0L;
            for (final var fastaBlock : RosalindUtils.fastaBlocks(dataset)) {
                final var dnaString = fastaBlock.getDescription();
                dnaLength = dnaString.length();
                for (int i = 0; i < dnaLength; i++) {
                    updateFreqOfDNASymbol(i, dnaString);
                }
            }
            buildConsensus(dnaLength);
        }

        @Override
        public String toString() {
            final var consensusAndProfile = new StringBuilder(consensus).append("\n");
            for (final var profileEntry : dnaSymbolToFreq.entrySet()) {
                consensusAndProfile.append(profileEntry.getKey())
                        .append(": ")
                        .append(Joiner.on(" ").join(profileEntry.getValue()))
                        .append("\n");
            }
            return consensusAndProfile.toString();
        }

        private void updateFreqOfDNASymbol(final int position,
                                           final String dnaString) {
            final var dnaSymbol = String.valueOf(dnaString.charAt(position));
            final var frequencies = dnaSymbolToFreq.computeIfAbsent(
                    dnaSymbol,
                    symbol -> new ArrayList<>(Collections.nCopies(dnaString.length(), 0)));
            frequencies.set(position, frequencies.get(position) + 1);
        }

        private void buildConsensus(final long dnaLength) {
            final var consensus = new StringBuilder();
            for (int i = 0; i < dnaLength; i++) {
                consensus.append(getMostCommonSymbolAt(i));
            }
            this.consensus = consensus.toString();
        }

        private String getMostCommonSymbolAt(final int position) {
            return dnaSymbolToFreq.entrySet().stream()
                    .max(Comparator.comparingInt(profileEntry -> profileEntry.getValue().get(position)))
                    .orElseThrow(IllegalArgumentException::new).getKey();
        }
    }
}
