package tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountingDNANucleotides {
    public static void countNucleotides(String filepath) {
        String dnaString = "";
        try {
            dnaString = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
            System.err.println("Exception while reading the source DNA file.");
            return;
        }
        System.out.print(dnaString.chars().filter(c -> c == 'A').count() + " "
                + dnaString.chars().filter(c -> c == 'C').count() + " "
                + dnaString.chars().filter(c -> c == 'G').count() + " "
                + dnaString.chars().filter(c -> c == 'T').count());
        System.out.println();
    }
}
