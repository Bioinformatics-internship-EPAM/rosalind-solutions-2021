package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Reader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String c = bufferedReader.readLine();
        String[] values = c.split(" ");

        int n = Integer.parseInt(values[0]);
        int m = Integer.parseInt(values[1]);

        int count = 0;

        for (int k = m; k <= n; k++){
            count += factorial(n)/(factorial(k)*factorial(n - k));
        }

        System.out.print(count);

    }
}