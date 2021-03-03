package tasks;

import java.util.ArrayList;
import java.util.List;

//Link: http://rosalind.info/problems/revp/
public class LocatingRestrictionSites {
    public static List<String> findReversePalindrome(String dna) {
        List<String> palindromes = new ArrayList<>();
        String reverseDna = new StringBuilder(ComplementingStrandOfDna.compute(dna)).reverse().toString();
        for (int i = 2; i <= 6; i++) {
            for (int j = 0; j <= dna.length() - i * 2; j++) {
                StringBuilder temp = new StringBuilder(reverseDna.substring(j + i, j + i * 2));
                if (dna.substring(j, j + i).equals(temp.reverse().toString())) {
                    palindromes.add((j + 1) + " " + i * 2);
                }
            }
        }
        return palindromes;
    }
}
