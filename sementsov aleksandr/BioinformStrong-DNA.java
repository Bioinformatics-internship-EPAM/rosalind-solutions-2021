//Dataset at the moment:
package com.company;
import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {

        //To load a dataset
        String s = "";
        try {
            FileReader reader = new FileReader("rosalind-DNA.txt", Charset.forName("utf-8"));
            while (reader.read() != -1) {
                s += (char)reader.read();
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //To convert to char array
        char[] c = s.toCharArray();
        char[] Nucleotids = {'A', 'C', 'G', 'T'};
        int freq = 0;

        //To init frequency for A, C, G and T components

        //To realize the algorithm
        for (int i = 0; i < 4; i++) {
            freq = 0;
            for (int j = 0; j < c.length; j++) {
                if (c[j] == Nucleotids[i]) {
                    freq++;
                }
            }
            System.out.printf("%d ", freq);
        }
    }
}