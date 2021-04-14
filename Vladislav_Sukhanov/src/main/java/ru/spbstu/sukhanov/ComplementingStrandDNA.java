package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ComplementingStrandDNA {
    public static final String FILENAME = "rosalind_revc.txt";

    public static void main(String[] args) {

        File file = new File(ComplementingStrandDNA.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String content = scanner.nextLine().toUpperCase();

        Map<Character, Character> replaceMap = new HashMap<>();
        replaceMap.put('A', 'T');
        replaceMap.put('T', 'A');
        replaceMap.put('G', 'C');
        replaceMap.put('C', 'G');

        String complementDNAString = "";
        for (int i = 0; i < content.length(); i++) {
            Character character = content.charAt(i);

            // Complementing all nitrogenous bases A - T, C - G
            complementDNAString += replaceMap.get(character);
        }

        StringBuilder reversedDNAString = new StringBuilder(complementDNAString).reverse();

        System.out.println(reversedDNAString);
    }
}
