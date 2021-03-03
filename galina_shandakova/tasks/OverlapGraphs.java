package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Link: http://rosalind.info/problems/grph/
public class OverlapGraphs {
    public static List<String> getAdjacencyList(Map<String, String> dna) {
        List<String> adjacencyList = new ArrayList<>();
        dna.forEach((name, dnaString) -> dna.forEach((name2, dnaString2) -> {
            if (dnaString.endsWith(dnaString2.substring(0, 3)) && !name.equals(name2)) {
                adjacencyList.add(name + " " + name2);
            }
        }));
        return adjacencyList;
    }
}
