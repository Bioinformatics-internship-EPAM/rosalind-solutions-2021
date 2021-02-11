package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;

import static ru.spbstu.shakhmin.utils.RosalindUtils.DNA_COMPLEMENTS;

public final class ComplementingAStrandOfDNATask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "complementing_a_strand_of_dna.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var complementOfDNAString = new StringBuilder();
        for (final var ch : dataset.get(0).toCharArray()) {
            complementOfDNAString.append(DNA_COMPLEMENTS.getOrDefault(ch, ch));
        }
        return complementOfDNAString.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ComplementingAStrandOfDNATask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
