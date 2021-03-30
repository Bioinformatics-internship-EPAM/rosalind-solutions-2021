package tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ComplementingaStrandofDNA {
    public static void complementDNA(String filepath) {
        String dnaString = "";
        try {
            dnaString = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
            System.err.println("Exception while reading the source DNA file.");
            return;
        }
        char [] reversedDNA = new StringBuilder(dnaString).reverse().toString().toCharArray();
        StringBuilder complementedDNA = new StringBuilder();
        for (char c: reversedDNA){
            if (c == 'G'){
                complementedDNA.append('C');
            }
            else if (c == 'T'){
                complementedDNA.append('A');
            }
            else if (c == 'C'){
                complementedDNA.append('G');
            }
            else if (c == 'A'){
                complementedDNA.append('T');
            }
        }
        System.out.print(complementedDNA.toString());
        System.out.println();
    }
}
