package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        String c = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            c = br.readLine();
        }

        int number = Integer.parseInt(c);

        int count = 0;

        for (int k = 0; k <= number; k++){
            count += factorial(number)/(factorial(k)*factorial(number - k));
        }

        System.out.print(count);

    }

}
