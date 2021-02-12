package com.company;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    
    static String[] getDataSet(String stringWay) throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, Charset.forname("utf-8")))) {
            Scanner scanner = new Scanner(brReader);
            String[] s = new String[2];
            s[0] = scanner.nextLine();
            s[1] = scanner.nextLine();
            return s;
        }
    }

    public static void main(String[] args) {

        //To load a dataset
        String[] dataSet = null;
        try {
            dataSet = getDataSet("rosalind-HAMM.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //To init frequency of differ
        int freq =0;

        //To realize the algorithm
        for(int i = 0; i < dataSet[0].length(); i++) {
            if (dataSet[0].charAt(i) != dataSet[1].charAt(i)) {
                freq++;
            }
        }

        //To set dataset-result
        System.out.print(freq);
    }
}
