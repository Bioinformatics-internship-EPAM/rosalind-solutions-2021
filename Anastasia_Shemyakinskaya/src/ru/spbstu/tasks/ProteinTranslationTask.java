package ru.spbstu.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProteinTranslationTask {
    private Map<String, String> table = new HashMap<>();
    private String rnaString;

    public ProteinTranslationTask(String rnaString) {
        this.rnaString = rnaString;
    }

    private void fillRnaCodonTable() throws IOException {
        Path path = Paths.get("rna_protein_table.txt");
        List<String> lines = Files.readAllLines(path);
        for (String str : lines) {
            String[] split = str.split(" ");
            for (String s : split) {
                String[] split1 = s.split(":");
                if (split1.length != 2) {
                    System.err.println("Wrong format of string: " + s);
                } else {
                    this.table.put(split1[0], split1[1]);
                }
            }
        }
    }

    public String constructProteinChain() {
        try {
            fillRnaCodonTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder proteinChain = new StringBuilder();
        for (int i = 0; i < this.rnaString.length()-4; i = i + 3 ){
            String codon = this.rnaString.substring(i, i + 3).trim();
            String proteinChar = this.table.get(codon);
            if (!proteinChar.equals("Stop")) {
                proteinChain.append(proteinChar);
            }
        }
        return proteinChain.toString();
    }
}
