package ru.spbstu.tasks;

import ru.spbstu.utils.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProteinTranslationTask {
    private Map<String, String> table = new HashMap<>();
    private String rnaString;
    private final Integer CODON_LENGTH = 3;

    public ProteinTranslationTask(String rnaString) {
        this.rnaString = rnaString;
    }

    public String constructProteinChain() {
        try {
            table = FileUtils.readTableAndReturnMap("rna_protein_table.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder proteinChain = new StringBuilder();
        for (int i = 0; i < this.rnaString.length(); i = i + CODON_LENGTH) {
            int codonEnd = i + CODON_LENGTH;
            if (codonEnd >= rnaString.length()) {
                break;
            }
            String codon = this.rnaString.substring(i, codonEnd).trim();
            String proteinChar = this.table.get(codon);
            if (proteinChar.equals("Stop")) {
                break;
            }
            proteinChain.append(proteinChar);
        }
        return proteinChain.toString();
    }
}
