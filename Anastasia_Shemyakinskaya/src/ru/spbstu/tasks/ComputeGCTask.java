package ru.spbstu.tasks;

import ru.spbstu.utils.FastaFile;

import java.io.IOException;
import java.util.Map;

public class ComputeGCTask {

    private String maxId;
    private Double maxPercentage = 0.0;

    public void countMaxGC() throws IOException {
        Map<String, String> dnaMap = FastaFile.readFileAndReturnDnaMap("compute_gc.fasta");
        for ( Map.Entry<String, String> entry : dnaMap.entrySet()) {
            String dna = entry.getValue();
            long count = dna.chars().filter(c -> c == 'G' || c == 'C').count();
            double gcPercentage = ((double) count) / ((double) dna.length()) * 100;
            if (maxPercentage < gcPercentage) {
                maxPercentage = gcPercentage;
                maxId = entry.getKey();
            }
        }
    }

    public String getMaxId() {
        return maxId;
    }

    public Double getMaxPercentage() {
        return maxPercentage;
    }
}
