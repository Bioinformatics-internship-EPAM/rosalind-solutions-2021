package ru.spbstu.shakhmin;

import com.google.common.base.Joiner;
import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CountingDNANucleotideTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "counting_dna_nucleotide.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var symbolToCount = dataset.get(0).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));
        return Joiner.on(" ").join(new TreeMap<>(symbolToCount).values());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new CountingDNANucleotideTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
