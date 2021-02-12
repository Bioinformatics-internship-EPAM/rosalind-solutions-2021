//Dataset at the moment:
package com.company;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //To load a dataset
        String s = "";
        try {
            FileReader reader = new FileReader("rosalind-DNA.txt", Charset.forName("utf-8"));
            Scanner scanner = new Scanner(reader);
            s = scanner.nextLine();
            scanner.close();
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        char[] Nucleotids = {'A', 'C', 'G', 'T'};
        int freq = 0;

        //To realize the algorithm
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == Nucleotids[i]) {
                    freq++;
                }
            }
            System.out.printf("%d ", freq);
            freq = 0;
        }
    }
}
