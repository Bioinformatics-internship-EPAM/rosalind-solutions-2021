package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.FastaBlock;
import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;
import java.util.stream.StreamSupport;

public final class ComputingGCContentTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "computing_gc_content.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var fastaBlockWithHighestGCContent =
                StreamSupport.stream(RosalindUtils.fastaBlocks(dataset).spliterator(), false)
                        .map(DNAFastaBlock::new)
                        .max(DNAFastaBlock::compareTo).orElseThrow(IllegalArgumentException::new);
        return fastaBlockWithHighestGCContent.getId() + "\n" + fastaBlockWithHighestGCContent.getGCContent();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ComputingGCContentTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }

    private static final class DNAFastaBlock extends FastaBlock implements Comparable<DNAFastaBlock> {
        private final double gcContent;

        private DNAFastaBlock(final FastaBlock fastaBlock) {
            super(fastaBlock);
            final var gcCount = getDescription()
                    .chars()
                    .filter(ch -> ch == 'C' || ch == 'G')
                    .count();
            gcContent = ((double) gcCount / getDescription().length()) * 100;
        }

        public double getGCContent() {
            return gcContent;
        }

        @Override
        public int compareTo(final DNAFastaBlock dnaFastaBlock) {
            return Double.compare(gcContent, dnaFastaBlock.gcContent);
        }
    }
}
