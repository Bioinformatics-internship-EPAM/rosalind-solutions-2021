package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String c = bufferedReader.readLine();

        char[] cArray = c.toCharArray();


        HashMap<Character, Double> MassTable = new HashMap<>();

        MassTable.put('A', 71.03711);
        MassTable.put('C', 103.00919);
        MassTable.put('D', 115.02694);
        MassTable.put('E', 129.04259);
        MassTable.put('F', 147.06841);
        MassTable.put('G', 57.02146);
        MassTable.put('H', 137.05891);
        MassTable.put('I', 113.08406);
        MassTable.put('K', 128.09496);
        MassTable.put('L', 113.08406);
        MassTable.put('M', 131.04049);
        MassTable.put('N', 114.04293);
        MassTable.put('P', 97.05276);
        MassTable.put('Q', 128.05858);
        MassTable.put('R', 156.10111);
        MassTable.put('S', 87.03203);
        MassTable.put('T', 101.04768);
        MassTable.put('V', 99.06841);
        MassTable.put('W', 186.07931);
        MassTable.put('Y', 163.06333);

        Double weight = 0.0;


        for (int i = 0; i < cArray.length; i++) {
            weight += MassTable.get(cArray[i]);
        }


        String result = String.format("%.3f",weight);

        System.out.print(result);

    }

}