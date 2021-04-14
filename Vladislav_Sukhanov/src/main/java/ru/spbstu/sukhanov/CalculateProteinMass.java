package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculateProteinMass {

    private static final String FILENAME = "rosalind_prtm.txt";

    private static final String MASS_TABLE = "mass_table.txt";

    private static final int MASS_TABLE_LENGTH = 20;

    public static void main(String[] args) {

        File file = new File(CalculateProteinMass.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String content = scanner.nextLine();

        Map<String, Double> massTable = getMassTable(MASS_TABLE, MASS_TABLE_LENGTH);

        System.out.println(massTable);

        double massCounter = 0;
        for (int i = 0; i < content.length(); i++) {
            massCounter += massTable.get(String.valueOf(content.charAt(i)));
        }

        System.out.println(massCounter);
    }

    private static Map<String, Double> getMassTable(String massTableName, int massTableLength) {
        File codon = new File(CalculateProteinMass.class.getClassLoader().getResource(massTableName).getFile());
        Scanner scannerMassTable = null;
        try {
            scannerMassTable = new Scanner(codon);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        Map<String, Double> massTable = new HashMap<>();

        for (int i = 0; i < massTableLength; i++) {
            String[] contentMass = scannerMassTable.nextLine().split(" ");
            massTable.put(contentMass[0], Double.valueOf(contentMass[1]));
        }

        return massTable;
    }
}
