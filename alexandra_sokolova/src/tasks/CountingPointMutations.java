package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountingPointMutations {
    public static void countMutations(String filepath) {
        String dnaString1 = "";
        String dnaString2 = "";
        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(filepath));
            dnaString1 = lineReader.readLine();
            dnaString2 = lineReader.readLine();
            lineReader.close();
            if (dnaString1.length() != dnaString2.length()){
                throw new IOException("Strings are not the same length.");
            }
        } catch (IOException e) {
            System.err.println("Exception while reading the source DNA file.");
            return;
        }
        int hammingDistance = 0;
        for (int i = 0; i < dnaString1.length(); i++){
            if (dnaString1.charAt(i) != dnaString2.charAt(i)){
                hammingDistance++;
            }
        }
        System.out.print(hammingDistance);
        System.out.println();
    }
}
