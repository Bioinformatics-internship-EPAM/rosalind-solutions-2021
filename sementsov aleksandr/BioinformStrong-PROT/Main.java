package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    
    static String getDataSet(String stringWay) throws IOException {
        String s = "";
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            s = scanner.nextLine();
        }
        return s;
    }

    public static void main(String[] args) {

        final char emptyCell = 'Ъ';

        //protein table interpriter in array. 'Stop' was swaped to special symbol
        String proteinTable = "UUU F CUU L AUU I GUU V " +
                "UUC F CUC L AUC I GUC V " +
                "UUA L CUA L AUA I GUA V " +
                "UUG L CUG L AUG M GUG V " +
                "UCU S CCU P ACU T GCU A " +
                "UCC S CCC P ACC T GCC A " +
                "UCA S CCA P ACA T GCA A " +
                "UCG S CCG P ACG T GCG A " +
                "UAU Y CAU H AAU N GAU D " +
                "UAC Y CAC H AAC N GAC D " +
                "UAA Ы CAA Q AAA K GAA E " +
                "UAG Ы CAG Q AAG K GAG E " +
                "UGU C CGU R AGU S GGU G " +
                "UGC C CGC R AGC S GGC G " +
                "UGA Ы CGA R AGA R GGA G " +
                "UGG W CGG R AGG R GGG G ";

        StringBuilder currentData = null;
        FileWriter writer = null;

        try {
            currentData = new StringBuilder(getDataSet("rosalind_prot.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for (int dataIndex = 0; dataIndex < currentData.length();) {
            for(int tableIndex = 0; tableIndex < proteinTable.length();) {
                if (currentData.charAt(dataIndex) == proteinTable.charAt(tableIndex)
                        && currentData.charAt(dataIndex+1) == proteinTable.charAt(tableIndex+1)
                        && currentData.charAt(dataIndex+2) == proteinTable.charAt(tableIndex+2)) {
                    if (proteinTable.charAt(tableIndex+4) != 'Ы') {
                        currentData.setCharAt(dataIndex, proteinTable.charAt(tableIndex+4));
                        currentData.setCharAt(dataIndex+1, emptyCell);
                        currentData.setCharAt(dataIndex+2, emptyCell);
                    }
                    else {
                        currentData.setCharAt(dataIndex, emptyCell);
                        currentData.setCharAt(dataIndex+1, emptyCell);
                        currentData.setCharAt(dataIndex+2, emptyCell);
                    }
                    dataIndex += 3;
                    tableIndex = proteinTable.length();
                }
                else {
                    tableIndex += 6;
                }
            }
        }

        try {
            writer = new FileWriter("output.txt", StandardCharsets.UTF_8);
            for (int i = 0; i < currentData.length(); i++) {
                if (currentData.charAt(i) != emptyCell) {
                    writer.append(currentData.charAt(i));
                }
            }
            writer.close();
            System.out.println("Dataset is loaded");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
