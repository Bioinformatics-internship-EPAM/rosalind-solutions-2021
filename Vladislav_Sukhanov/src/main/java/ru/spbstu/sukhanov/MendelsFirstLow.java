package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MendelsFirstLow {

    private static final String FILENAME = "rosalind_iprb.txt";

    public static void main(String[] args) {

        File file = new File(MendelsFirstLow.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String[] content = scanner.nextLine().split(" ");

        int k = Integer.parseInt(content[0]); // AA
        int m = Integer.parseInt(content[1]); // Aa
        int n = Integer.parseInt(content[2]); // aa

        int allPopulation = k + m + n ;

        double fullProb = allPopulation * (allPopulation - 1) / 2;

        double AA_AA = (1 * (k * (k - 1)) / 2) / fullProb;
        double AA_Aa = (1 * (k * m)) / fullProb;
        double AA_aa = (1 * (k * n)) / fullProb;
        double Aa_Aa = (0.75 * (m * (m - 1) / 2)) / fullProb;
        double Aa_aa = (0.5 * (m * n)) / fullProb;

        double probability = AA_AA + AA_Aa + AA_aa + Aa_Aa + Aa_aa;
        System.out.println(probability);
    }
}
