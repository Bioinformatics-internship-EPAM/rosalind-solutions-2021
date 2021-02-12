package com.company;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String s1 = "";
        String s2 = "";

        //To load a dataset
        try {
            FileReader reader = new FileReader("rosalind-HAMM.txt", Charset.forName("utf-8"));
            Scanner scanner = new Scanner(reader);
            s1 = scanner.nextLine();
            s2 = scanner.nextLine();
            scanner.close();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //To init frequency of differ
        int freq =0;

        //To realize the algorithm
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                freq++;
            }
        }

        //To set dataset-result
        System.out.print(freq);
    }
}
