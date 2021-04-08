package ru.spbstu.sukhanov;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CounterDNANucls {

    private static final String FILENAME = "rosalind_dna.txt";

    public static void main(String[] args) {

        Map<Character, Integer> counter = new HashMap<>(Map.of(
                'A', 0,
                'C', 0,
                'G', 0,
                'T', 0
        ));

        File file = new File(CounterDNANucls.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String content = scanner.nextLine().toUpperCase();

        int localCounter = 0;
        for (int i = 0; i < content.length(); i++) {
            Character character = content.charAt(i);
            localCounter = counter.get(character);
            counter.put(character, localCounter + 1);
        }

        System.out.println(counter);
    }
}
