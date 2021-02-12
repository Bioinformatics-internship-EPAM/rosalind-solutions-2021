package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //protein table interpriter in array. 'Stop' was swaped to special symbol
        String s1 = "UUU F CUU L AUU I GUU V " +
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
        char[] c1 = s1.toCharArray();

        String s = "";
        FileWriter writer = null;

        try {
            FileReader reader = new FileReader("rosalind-PROT.txt", Charset.forName("utf-8"));
            Scanner scanner = new Scanner(reader);
            s = scanner.nextLine();
            scanner.close();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //To convert to char array
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length;) {
            for(int j = 0; j < c1.length;) {
                if (c[i] == c1[j] && c[i+1] == c1[j+1] && c[i+2] == c1[j+2]) {
                    if (c1[j+4] != 'Ы') {
                        c[i] = c1[j+4];
                        c[i+1] = 'Ъ';
                        c[i+2] = 'Ъ';
                    }
                    else {
                        c[i] = 'Ъ';
                        c[i+1] = 'Ъ';
                        c[i+2] = 'Ъ';
                    }
                    i += 3;
                    j = c1.length;
                }
                else {
                    j += 6;
                }
            }
        }

        try {
            writer = new FileWriter("output.txt", Charset.forName("utf-8"));
            for (int i = 0; i < c.length; i++) {
                if (c[i] != 'Ъ') {
                    writer.append(c[i]);
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
