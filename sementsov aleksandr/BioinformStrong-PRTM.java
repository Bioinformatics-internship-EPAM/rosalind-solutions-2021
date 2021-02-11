package com.company;


import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        //the first column mass protein
        String s = "A" +
                "C" +
                "D" +
                "E" +
                "F" +
                "G" +
                "H" +
                "I" +
                "K" +
                "L" +
                "M" +
                "N" +
                "P" +
                "Q" +
                "R" +
                "S" +
                "T" +
                "V" +
                "W" +
                "Y";

        //the second column mass protein
        double[] z = {
            71.03711,
            103.00919,
            115.02694,
            129.04259,
            147.06841,
            57.02146,
            137.05891,
            113.08406,
            128.09496,
            113.08406,
            131.04049,
            114.04293,
            97.05276,
            128.05858,
            156.10111,
            87.03203,
            101.04768,
            99.06841,
            186.07931,
            163.06333
        };

        String loadedData = "";
        try {
            FileReader reader = new Filereader("rosalind-PRTM.txt", Charset.forname("utf-8"));
            Scanner scanner = new Scanner(reader);
            loadedData = scanner.nextLine();
            scanner.close();
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        double summ = 0;

        for (int i = 0; i < loadedData.length(); i++) {
            
            //each letter is assigned its own mass value
            summ += z[s.indexOf(loadedData.charAt(i))];
        }

        System.out.println(String.format("%.3f", summ));
    }
}
