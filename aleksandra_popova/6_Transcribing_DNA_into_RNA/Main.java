package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String c = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            c = br.readLine();
        }

        System.out.println(c.replace("T", "U"));
    }
}
