package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;

public final class CountingPointMutationsTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "counting_point_mutations.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var dna1 = dataset.get(0);
        final var dna2 = dataset.get(1);
        var hammingDistance = 0;
        for (int i = 0; i < dna1.length(); i++) {
            if (dna1.charAt(i) != dna2.charAt(i)) {
                hammingDistance++;
            }
        }
        return String.valueOf(hammingDistance);
    }

    public static void main(final String[] args) throws Exception {
        System.out.println(new CountingPointMutationsTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
