package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    
    static String getDataSet(String stringWay) throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, Charset.forname("utf-8")))) {
            Scanner scanner = new Scanner(reader);
            s = scanner.nextLine();
        }
        return s;
    }

    public static void main(String[] args) {

        //To load a dataset
        String s = "";

        try {
            s = getDataSet("rosalind-RNA.txt");
        }
        catch (IOException e) {
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
