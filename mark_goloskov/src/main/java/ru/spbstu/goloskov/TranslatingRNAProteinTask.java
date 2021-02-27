package ru.spbstu.goloskov;

import com.google.common.base.Splitter;
import ru.spbstu.goloskov.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslatingRNAProteinTask {

    private static final String RNA_CODON_TABLE = "RNACodonTable.txt";
    private static final int CODON_LENGTH = 3;
    private static final String STOP = "Stop";

    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readFile(Utils.TRANSLATING_RNA_PROTEIN);
        Map<String, String> codonToAminoAcid = getRNACodonTable();
        for(String codon : Splitter.fixedLength(CODON_LENGTH).split(lines.get(0))) {
            String aminoAcid = codonToAminoAcid.get(codon);
            if (STOP.equals(aminoAcid)) {
                break;
            }
            System.out.print(aminoAcid);
        }
    }

    private static Map<String, String> getRNACodonTable() throws URISyntaxException, IOException {
        Map<String, String> codonToAminoAcid = new HashMap<>();
        List<String> lines = Utils.readFile(RNA_CODON_TABLE);
        for (String line : lines) {
            String[] codonPairs = line.split("\\s\\s+");
            for (String codonPair : codonPairs) {
                String[] splitCodonPair = codonPair.split("\\s");
                codonToAminoAcid.put(splitCodonPair[0], splitCodonPair[1]);
            }
        }
        return codonToAminoAcid;
    }
}
