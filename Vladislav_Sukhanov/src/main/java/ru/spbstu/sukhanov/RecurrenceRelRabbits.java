package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecurrenceRelRabbits {

    private static final String FILENAME = "rosalind_fib.txt";

    public static void main(String[] args) {

        File file = new File(RecurrenceRelRabbits.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String[] content = scanner.nextLine().split(" ");
        System.out.println(countRabbits(Integer.parseInt(content[0]), Integer.parseInt(content[1])));
    }

    private static long countRabbits(int months, int rabbitPairsPerMonth) throws IllegalArgumentException {
        if (months < 0 || rabbitPairsPerMonth < 0) {
            throw new IllegalArgumentException();
        }

        if (months <= 2) {
            return 1;
        }

        return countRabbits(months - 2, rabbitPairsPerMonth) * rabbitPairsPerMonth +
                countRabbits(months - 1, rabbitPairsPerMonth);
    }
}
