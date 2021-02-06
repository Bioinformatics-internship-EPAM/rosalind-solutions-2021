package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;
import java.util.StringJoiner;

public class FindingAMotifInDNATask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "finding_a_motif_in_dna.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var string = dataset.get(0);
        final var substring = dataset.get(1);
        final var answer = new StringJoiner(" ");
        var index = string.indexOf(substring);
        while (index >= 0) {
            answer.add(String.valueOf(index + 1));
            index = string.indexOf(substring, index + 1);
        }
        return answer.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new FindingAMotifInDNATask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
