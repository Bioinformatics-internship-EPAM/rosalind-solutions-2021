package tasks;

import java.util.ArrayList;
import java.util.List;

//Link: http://rosalind.info/problems/subs/
public class FindingMotifInDna {
    public static List<Integer> findMotif(String dna, String part) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i <= dna.length() - part.length(); i++) {
            if (dna.startsWith(part, i)) {
                positions.add(i + 1);
            }
        }
        return positions;
    }
}
