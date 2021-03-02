package task;

import utils.fasta.FASTAItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Overlap Graphs
 *
 * http://rosalind.info/problems/grph/
 */
public class OverlapGraphBuilder {

    /**
     * Build overlap graph
     *
     * @param dnaSequences - list of graph vertices. For more details see: {@link FASTAItem}
     * @param suffixLength - suffix and prefix length
     * @return - list of graph edges. edges. Edges is given as the label of the start and end vertices
     */
    public static List<List<String>> build(List<FASTAItem> dnaSequences, int suffixLength) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < dnaSequences.size(); i++) {
            String suffix = dnaSequences.get(i).getSequence()
                    .substring(dnaSequences.get(i).getSequence().length() - suffixLength);
            for (int j = 0; j < dnaSequences.size(); j++) {
                if (i != j) {
                    if (dnaSequences.get(j).getSequence().startsWith(suffix)) {
                        result.add(List.of(dnaSequences.get(i).getLabel(), dnaSequences.get(j).getLabel()));
                    }
                }
            }
        }
        return result;
    }

}
