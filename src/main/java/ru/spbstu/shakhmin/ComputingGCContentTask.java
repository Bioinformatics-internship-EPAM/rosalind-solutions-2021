package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;

import static ru.spbstu.shakhmin.utils.RosalindUtils.FASTA_LABEL;

public final class ComputingGCContentTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "computing_gc_content.txt";

    @Override
    public String resolve(final List<String> dataset) {
        var idWithHighestGCContent = "";
        var highestGCContent = 0.0;
        var gcCount = 0L;
        var dnaLength = 0L;
        for (int i = dataset.size() - 1; i >= 0; i--) {
            final var line = dataset.get(i);
            if (line.startsWith(FASTA_LABEL)) {
                final var currentId = line.substring(1);
                if (dnaLength != 0L) {
                    final var currentGCContent = (double) gcCount / dnaLength;
                    highestGCContent = Math.max(highestGCContent, currentGCContent);
                    if (highestGCContent == currentGCContent) {
                        idWithHighestGCContent = currentId;
                    }
                }
                gcCount = 0L;
                dnaLength = 0L;
            } else {
                gcCount += line.chars()
                        .filter(ch -> ch == 'C' || ch == 'G')
                        .count();
                dnaLength += line.length();
            }
        }
        return idWithHighestGCContent + "\n" + (highestGCContent * 100);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ComputingGCContentTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
