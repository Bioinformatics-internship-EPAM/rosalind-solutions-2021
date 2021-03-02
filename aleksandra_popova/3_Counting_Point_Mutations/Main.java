package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException {
        String c = "";
        String t = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            c = br.readLine();
            t = br.readLine();
        }

        char[] cArray = c.toCharArray();
        char[] tArray = t.toCharArray();

        int count = 0;

        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] != tArray[i]) {
                count++;
            }
        }

        System.out.println(count);


    }
}
