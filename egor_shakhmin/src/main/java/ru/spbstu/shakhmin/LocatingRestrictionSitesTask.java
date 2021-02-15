package ru.spbstu.shakhmin;

import com.google.common.base.Joiner;
import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;

import static ru.spbstu.shakhmin.utils.RosalindUtils.DNA_COMPLEMENTS;

public final class LocatingRestrictionSitesTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "locating_restriction_sites.txt";
    private static final int MIN_PALINDROME_LENGTH = 4;
    private static final int MAX_PALINDROME_LENGTH = 12;

    private static String reverseComplement(final String dnaString) {
        final var reverseComplement = new StringBuilder();
        for (final var ch : dnaString.toCharArray()) {
            reverseComplement.append(DNA_COMPLEMENTS.get(ch));
        }
        return reverseComplement.reverse().toString();
    }

    @Override
    public String resolve(final List<String> dataset) {
        final var positionAndLengthPairs = new StringBuilder();
        final var dnaString = Joiner.on("").join(dataset.subList(1, dataset.size()));
        final var dnaLength = dnaString.length();
        for (int i = 0; i < dnaLength; i++) {
            for (int j = MIN_PALINDROME_LENGTH; j <= MAX_PALINDROME_LENGTH; j++) {
                if (i + j > dnaLength) {
                    break;
                }
                final var dnaSubstring = dnaString.substring(i, i + j);
                if (dnaSubstring.equals(reverseComplement(dnaSubstring))) {
                    positionAndLengthPairs.append(i + 1).append(" ").append(j).append("\n");
                }
            }
        }
        return positionAndLengthPairs.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new LocatingRestrictionSitesTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
