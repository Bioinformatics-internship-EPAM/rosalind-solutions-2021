package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class LocatingRestrictionSitesTask {

    private static final int MIN_PALINDROME_LENGTH = 4;
    private static final int MAX_PALINDROME_LENGTH = 12;

    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readFile(Utils.LOCATING_RESTRICTION_SITES);
        StringBuilder dna = new StringBuilder();
        for (String line : lines.subList(1, lines.size())) {
            dna.append(line);
        }
        int dnaLength = dna.length();
        for (int i = 0; i < dna.length(); i++) {
            for (int j = MIN_PALINDROME_LENGTH; j <= MAX_PALINDROME_LENGTH; j++) {
                if (i + j > dnaLength) {
                    break;
                }
                String substringDNA = dna.substring(i, i + j);
                if (substringDNA.equals(Utils.reverseComplement(substringDNA))) {
                    System.out.printf("%d %d\n", i + 1, j);
                }
            }
        }

    }
}
