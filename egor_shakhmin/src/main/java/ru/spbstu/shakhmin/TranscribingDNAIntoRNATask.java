package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;

public final class TranscribingDNAIntoRNATask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "transcribing_dna_into_rna.txt";

    @Override
    public String resolve(final List<String> dataset) {
        return dataset.get(0).replace('T', 'U');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new TranscribingDNAIntoRNATask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
