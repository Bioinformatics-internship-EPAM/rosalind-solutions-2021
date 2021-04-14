package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TranscribingDNAtoRNA {
    public static final String FILENAME = "rosalind_rna.txt";

    public static void main(String[] args) {

        File file = new File(TranscribingDNAtoRNA.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String content = scanner.nextLine().toUpperCase();

        String formattedRNAString = "";
        for (int i = 0; i < content.length(); i++) {
            Character character = content.charAt(i);

            // Replacing all nitrogenous bases T to U
            if (character == 'T') {
                formattedRNAString += 'U';
            } else {
                formattedRNAString += character;
            }
        }

        System.out.println(formattedRNAString);
    }
}
