package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindMotifDNA {

    private static final String FILENAME = "rosalind_subs.txt";

    public static void main(String[] args) {

        File file = new File(FindMotifDNA.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        int index = 0;
        index = line1.indexOf(line2);
        while (index >= 0) {
            result.append(index + 1).append(" ");
            index++;
            index = line1.indexOf(line2, index);
        }

        System.out.println("Result: " + result);
    }
}
