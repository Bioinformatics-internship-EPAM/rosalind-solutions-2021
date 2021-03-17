package tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TranscribingDNAintoRNA {
    public static void transcribeDNA(String filepath) {
        String dnaString = "";
        try {
            dnaString = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
            System.err.println("Exception while reading the source DNA file.");
            return;
        }
        System.out.print(dnaString.replace('T', 'U'));
        System.out.println();
    }
}
