package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //To load a dataset
        String s = "";

        try {
            FileReader reader = new FileReader("rosalind-RNA.txt", Charset.forName("utf-8"));
            Scanner scanner = new Scanner(reader);
            s = scanner.nextLine();
            scanner.close();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        FileWriter writer = null;

        //To realize the algorithm
        try {
            writer = new FileWriter("output.txt", Charset.forName("utf-8"));
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'T') {
                    writer.append('U');
                }
                else {
                    writer.append(s.charAt(i));
                }
            }
            writer.close();
            System.out.println("Results are saved");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
