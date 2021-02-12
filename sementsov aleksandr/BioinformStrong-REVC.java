package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String s = "";

        //To load a dataset
        try {
            FileReader reader = new FileReader("rosalind-REVC.txt", Charset.forName("utf-8"));
            Scanner scanner = new Scanner(reader);
            s = scanner.nextLine();
            scanner.close();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        char[] nucleotids = new char[]{'A', 'C', 'T', 'G'};
        int j = 0;
        //To realize the algorithm
        try {
            FileWriter writer = new FileWriter("output.txt", Charset.forName("utf-8"));
            for (int i = s.length() - 1; i > -1; i--) {
                for (j = 0; j < 4; j++) {
                    if (s.charAt(i) == nucleotids[j]) {
                        writer.append(nucleotids[((j + 2) % 4)]);
                    }
                }
            }
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
