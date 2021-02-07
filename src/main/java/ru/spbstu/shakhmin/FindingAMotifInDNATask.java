package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;
import java.util.StringJoiner;

public class FindingAMotifInDNATask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "finding_a_motif_in_dna.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var dnaString = dataset.get(0);
        final var dnaSubstring = dataset.get(1);
        final var locations = new StringJoiner(" ");
        var index = dnaString.indexOf(dnaSubstring);
        while (index >= 0) {
            locations.add(String.valueOf(index + 1));
            index = dnaString.indexOf(dnaSubstring, index + 1);
        }
        return locations.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new FindingAMotifInDNATask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
