package PROT;

import utils.Utils;

import java.util.HashMap;

public class PROT {
    private static final String FILE_NAME = "prot_input.txt";
    private static final String FILE_PATH = "src/PROT/" + FILE_NAME;
    private static final byte CODON_LENGTH = 3;

    static HashMap<String, String> rnaCodonTable;

    public static void main(String[] args) throws Exception {
        String s = Utils.readFromFile(FILE_PATH).get(0);

        System.out.println(PROT.encodeProteinString(s));
    }

    static public String encodeProteinString(String s) {
        createTable();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length() - CODON_LENGTH; i = i + CODON_LENGTH) {
            String codon = s.substring(i, i + CODON_LENGTH);
            String aminoSequence = rnaCodonTable.get(codon);
            if (aminoSequence == "Stop") {
                break;
            }
            result.append(aminoSequence);
        }
        return result.toString();
    }

    static void createTable() {
        rnaCodonTable = new HashMap<>();

        rnaCodonTable.put("UUU", "F");
        rnaCodonTable.put("UUC", "F");
        rnaCodonTable.put("UUA", "L");
        rnaCodonTable.put("UUG", "L");
        rnaCodonTable.put("UCU", "S");
        rnaCodonTable.put("UCC", "S");
        rnaCodonTable.put("UCA", "S");
        rnaCodonTable.put("UCG", "S");
        rnaCodonTable.put("UAU", "Y");
        rnaCodonTable.put("UAC", "Y");
        rnaCodonTable.put("UAA", "Stop");
        rnaCodonTable.put("UAG", "Stop");
        rnaCodonTable.put("UGU", "C");
        rnaCodonTable.put("UGC", "C");
        rnaCodonTable.put("UGA", "Stop");
        rnaCodonTable.put("UGG", "W");

        rnaCodonTable.put("CUU", "L");
        rnaCodonTable.put("CUC", "L");
        rnaCodonTable.put("CUA", "L");
        rnaCodonTable.put("CUG", "L");
        rnaCodonTable.put("CCU", "P");
        rnaCodonTable.put("CCC", "P");
        rnaCodonTable.put("CCA", "P");
        rnaCodonTable.put("CCG", "P");
        rnaCodonTable.put("CAU", "H");
        rnaCodonTable.put("CAC", "H");
        rnaCodonTable.put("CAA", "Q");
        rnaCodonTable.put("CAG", "Q");
        rnaCodonTable.put("CGU", "R");
        rnaCodonTable.put("CGC", "R");
        rnaCodonTable.put("CGA", "R");
        rnaCodonTable.put("CGG", "R");

        rnaCodonTable.put("AUU", "I");
        rnaCodonTable.put("AUC", "I");
        rnaCodonTable.put("AUA", "I");
        rnaCodonTable.put("AUG", "M");
        rnaCodonTable.put("ACU", "T");
        rnaCodonTable.put("ACC", "T");
        rnaCodonTable.put("ACA", "T");
        rnaCodonTable.put("ACG", "T");
        rnaCodonTable.put("AAU", "N");
        rnaCodonTable.put("AAC", "N");
        rnaCodonTable.put("AAA", "K");
        rnaCodonTable.put("AAG", "K");
        rnaCodonTable.put("AGU", "S");
        rnaCodonTable.put("AGC", "S");
        rnaCodonTable.put("AGA", "R");
        rnaCodonTable.put("AGG", "R");

        rnaCodonTable.put("GUU", "V");
        rnaCodonTable.put("GUC", "V");
        rnaCodonTable.put("GUA", "V");
        rnaCodonTable.put("GUG", "V");
        rnaCodonTable.put("GCU", "A");
        rnaCodonTable.put("GCC", "A");
        rnaCodonTable.put("GCA", "A");
        rnaCodonTable.put("GCG", "A");
        rnaCodonTable.put("GAU", "D");
        rnaCodonTable.put("GAC", "D");
        rnaCodonTable.put("GAA", "E");
        rnaCodonTable.put("GAG", "E");
        rnaCodonTable.put("GGU", "G");
        rnaCodonTable.put("GGC", "G");
        rnaCodonTable.put("GGA", "G");
        rnaCodonTable.put("GGG", "G");
    }
}
