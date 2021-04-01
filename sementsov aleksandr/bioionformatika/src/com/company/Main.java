//Dataset at the moment:
package com.company;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;


public class Main {
    
    static String getDataSet(String stringWay) throws IOException {
        String s = "";
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, Charset.forName("utf-8")))) {
            Scanner scanner = new Scanner(brReader);
            s = scanner.nextLine();
        }
        return s;
    }

    public static void main(String[] args) {

        //To load a dataset
        String s = "";
        try {
            s = getDataSet("rosalind-DNA.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        char[] nucleotids = {'A', 'C', 'G', 'T'};
        int freq = 0;

        //To realize the algorithm
        for (int i = 0; i < nucleotids.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == nucleotids[i]) {
                    freq++;
                }
            }
            System.out.printf("%d ", freq);
            freq = 0;
        }
    }
}
