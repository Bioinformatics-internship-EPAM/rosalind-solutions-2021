package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindingaMotifinDNA {
    public static void findMotif(String filepath) {
        String dnaString = "";
        String motif = "";
        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(filepath));
            dnaString = lineReader.readLine();
            motif = lineReader.readLine();
            lineReader.close();
            if (dnaString == null ||  motif == null){
                throw new IOException("Strings should not be null.");
            }
        } catch (IOException e) {
            System.err.println("Exception while reading the source DNA file.");
        }
        int history = dnaString.indexOf(motif) + 1;
        while(history!= 0){
            System.out.print(history + " ");
            history = dnaString.indexOf(motif, history) + 1;
        }
        System.out.println();
    }
}
