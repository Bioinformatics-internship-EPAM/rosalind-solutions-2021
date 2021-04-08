package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TranslateRNAintoProtein {

    private static final String FILENAME = "rosalind_prot.txt";

    private static final String CODON_TABLE = "codon_table.txt";

    private static final int CODON_TABLE_LENGTH = 64;
    private static final int RNA_LENGTH = 3;

    public static void main(String[] args) {

        File file = new File(TranslateRNAintoProtein.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String content = scanner.nextLine();

        Map<String, String> codonTable = getCodonTable(CODON_TABLE, CODON_TABLE_LENGTH);

        StringBuilder protein = new StringBuilder();
        String letter = "";
        for (int i = 0; i < content.length(); i = i + RNA_LENGTH) {
            letter = codonTable.get(content.substring(i, i + RNA_LENGTH));
            if (letter.equals("Stop")) {
                break;
            }

            protein.append(letter);
        }

        System.out.println(protein);
    }

    private static Map<String, String> getCodonTable(String codonTableName, int codonTableLength) {
        File codon = new File(TranslateRNAintoProtein.class.getClassLoader().getResource(codonTableName).getFile());
        Scanner scannerCodon = null;
        try {
            scannerCodon = new Scanner(codon);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        Map<String, String> codonTable = new HashMap<>();

        for (int i = 0; i < codonTableLength; i++) {
            String[] contentCodon = scannerCodon.nextLine().split(" ");
            codonTable.put(contentCodon[0], contentCodon[1]);
        }

        return codonTable;
    }
}
