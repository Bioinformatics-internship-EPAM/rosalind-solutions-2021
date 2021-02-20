package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.FastaBlock;
import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class ComputingGCContentTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "computing_gc_content.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var fastaBlocks = StreamSupport.stream(
                RosalindUtils.fastaBlocks(dataset).spliterator(), false);
        final var gcContentById = fastaBlocks.collect(Collectors.toMap(
                FastaBlock::getId,
                block -> computeGcContent(block.getDescription())
        ));
        return gcContentById.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(entry -> entry.getKey() + "\n" + entry.getValue())
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ComputingGCContentTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }

    private static double computeGcContent(final String description) {
        final var gcCount = description.chars()
                .filter(ch -> ch == 'C' || ch == 'G')
                .count();
        return ((double) gcCount / description.length()) * 100;
    }
}
