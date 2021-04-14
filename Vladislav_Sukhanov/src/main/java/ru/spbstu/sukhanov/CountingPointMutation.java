package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.IllegalFormatWidthException;
import java.util.Scanner;

public class CountingPointMutation {

    private static final String FILENAME = "rosalind_hamm.txt";

    public static void main(String[] args) {

        File file = new File(CountingPointMutation.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        System.out.println(countDNADifferences(line1, line2));
    }

    private static int countDNADifferences(String str1, String str2) throws IllegalArgumentException {
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException();
        }

        int differences = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                differences++;
            }
        }
        return differences;
    }
}
