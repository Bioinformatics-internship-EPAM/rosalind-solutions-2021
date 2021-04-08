package ru.spbstu.sukhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingGCContent {

    private static final String FILENAME = "rosalind_gc.txt";

    public static void main(String[] args) {

        File file = new File(CountingGCContent.class.getClassLoader().getResource(FILENAME).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        double GCPercentage = 0.0;
        double bestGCPercentage = 0.0;

        String dataBlock = "";
        String fastaBlockName = "";
        String bestFastaBlockName = "";

        String lineContent = scanner.nextLine();
        // Reading the entire file
        while (!lineContent.isEmpty()) {
            if (lineContent.startsWith(">")) {
                fastaBlockName = lineContent.substring(1);
                dataBlock = "";

                lineContent = scanner.nextLine();

                // Splitting the file into separate blocks
                while (!lineContent.startsWith(">") && !lineContent.isEmpty()) {
                    dataBlock += lineContent;
                    lineContent = scanner.nextLine();
                }

                GCPercentage = countGCPercentage(dataBlock);
                if (GCPercentage > bestGCPercentage) {
                    bestGCPercentage = GCPercentage;
                    bestFastaBlockName = fastaBlockName;
                }
            }
        }

        System.out.println(bestFastaBlockName + " " + bestGCPercentage * 100);
    }

    private static double countGCPercentage(String block) {

        int counter = 0;
        for (int i = 0; i < block.length(); i++) {
            if (block.charAt(i) == 'C' || block.charAt(i) == 'G') {
                counter++;
            }
        }

        return (double) counter / block.length();
    }
}
