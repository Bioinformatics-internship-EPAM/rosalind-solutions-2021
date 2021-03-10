package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        String c = "";
        String t = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            c = br.readLine();
            t = br.readLine();
        }

        int number = Integer.parseInt(c);
        String[] values = t.split(" ");

        double[] result = new double[values.length];
        for (int i = 0; i < values.length; i++){
            double value = Double.parseDouble(values[i]);
            result[i] = number * value;
        }

        for (double val : result) {
            System.out.print(String.format(Locale.US, "%.1f",val) + " ");
        }
    }
}