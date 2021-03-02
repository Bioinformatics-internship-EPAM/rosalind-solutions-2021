package my.rosalind;

import my.rosalind.models.ResponseGC;

import java.util.HashMap;
import java.util.Map;

public class ComputingGCContent {
    private Map<String, String> getDnaSets(String dataset) {
        dataset = dataset.replace("\n", " ");

        var result = new HashMap<String, String>();
        var sets = dataset.split(">");
        for (var fasta : sets) {
            if (fasta.isEmpty()) {
                continue;
            }

            var blocks = fasta.split(" ");
            var id = blocks[0];

            var dnaBuilder = new StringBuilder();

            for (int i = 1; i < blocks.length; i++) {
                dnaBuilder.append(blocks[i]);
            }

            var dna = dnaBuilder.toString();

            result.put(id, dna);
        }

        return result;
    }

    private double getGC(String dna) {
        if (dna.length() == 0) {
            return 0;
        }

        int count = 0;
        for (var symbol : dna.toCharArray()) {
            if (symbol == 'C' || symbol == 'G') {
                count++;
            }
        }

        return ((double)count / dna.length()) * 100;
    }

    public ResponseGC exec(String dataset) {
        var sets = getDnaSets(dataset);

        String highestID = null;
        double highestVal = 0.0;

        for (var set : sets.entrySet()) {
            var dna = set.getValue();
            var gc = getGC(dna);

            if (gc > highestVal) {
                highestVal = gc;
                highestID = set.getKey();
            }
        }

        return new ResponseGC(highestID, highestVal);
    }
}
