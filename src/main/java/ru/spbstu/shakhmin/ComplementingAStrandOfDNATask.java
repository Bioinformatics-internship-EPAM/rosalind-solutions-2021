package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;

import static ru.spbstu.shakhmin.utils.RosalindUtils.COMPLEMENTS;

public final class ComplementingAStrandOfDNATask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "complementing_a_strand_of_dna.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var answer = new StringBuilder();
        for (final var ch : dataset.get(0).toCharArray()) {
            answer.append(COMPLEMENTS.getOrDefault(ch, ch));
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ComplementingAStrandOfDNATask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
