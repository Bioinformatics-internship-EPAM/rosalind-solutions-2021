package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        String c = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            c = br.readLine();
        }

        char[] cArray = c.toCharArray();

        Map<Character, Double> massTable = new HashMap<>();

        massTable.put('A', 71.03711);
        massTable.put('C', 103.00919);
        massTable.put('D', 115.02694);
        massTable.put('E', 129.04259);
        massTable.put('F', 147.06841);
        massTable.put('G', 57.02146);
        massTable.put('H', 137.05891);
        massTable.put('I', 113.08406);
        massTable.put('K', 128.09496);
        massTable.put('L', 113.08406);
        massTable.put('M', 131.04049);
        massTable.put('N', 114.04293);
        massTable.put('P', 97.05276);
        massTable.put('Q', 128.05858);
        massTable.put('R', 156.10111);
        massTable.put('S', 87.03203);
        massTable.put('T', 101.04768);
        massTable.put('V', 99.06841);
        massTable.put('W', 186.07931);
        massTable.put('Y', 163.06333);

        Double weight = 0.0;

        for (int i = 0; i < cArray.length; i++) {
            weight += massTable.get(cArray[i]);
        }


        String result = String.format("%.3f", weight);
        System.out.print(result);
    }
}
