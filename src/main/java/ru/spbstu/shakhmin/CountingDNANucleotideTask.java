package ru.spbstu.shakhmin;

import com.google.common.base.Joiner;
import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;
import java.util.TreeMap;

public final class CountingDNANucleotideTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "counting_dna_nucleotide.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var symbolToCount = new TreeMap<String, Integer>();
        for (final var ch : dataset.get(0).toCharArray()) {
            symbolToCount.compute(
                    String.valueOf(ch),
                    (symbol, count) -> count == null ? 1 : count + 1);
        }
        return Joiner.on(" ").join(symbolToCount.values());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new CountingDNANucleotideTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
