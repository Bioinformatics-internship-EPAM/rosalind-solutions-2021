package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class ComputingGCContentTask {
    private static final String FASTA_PREFIX = ">";

    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readFile(Utils.COMPUTING_GC_CONTENT);
        String maxID = "";
        double maxGC = 0.0;
        StringBuilder dna = new StringBuilder();
        for (int i = lines.size() - 1; i >= 0; i--) {
            String line = lines.get(i);
            if (line.startsWith(FASTA_PREFIX)) {
                String currentID = line.substring(1);
                double countGC = dna.chars()
                        .filter(c -> c == 'G' || c == 'C')
                        .count();
                double currentGC = countGC / dna.length();
                maxGC = Math.max(maxGC, currentGC);
                if (maxGC == currentGC) {
                    maxID = currentID;
                }
                dna = new StringBuilder();
            } else {
                dna.append(line);
            }
        }

        System.out.println(maxID);
        System.out.println(maxGC * 100);
    }
}
