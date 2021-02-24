package my.rosalind;

import java.util.ArrayList;

public class FindingAMotifInDNA {
    public int[] exec(String dnaS, String dnaT) {
        var list = new ArrayList<Integer>();

        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = dnaS.indexOf(dnaT, lastIndex);
            if (lastIndex != -1) {
                list.add(lastIndex + 1);
                lastIndex++;
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}
