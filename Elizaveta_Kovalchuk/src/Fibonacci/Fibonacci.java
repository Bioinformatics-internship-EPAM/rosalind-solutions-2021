package Fibonacci;

import java.io.*;
import java.util.Scanner;

public class Fibonacci {

    public static int numFib(int a) throws Exception {
        if (a < 0)
            throw new Exception("Error: number < 0");
        else if (a < 2)
            return a;
        else
            return numFib(a - 1) + numFib(a - 2);
    }

    public static void main(String[] args) {
        String pathIn = "src/Fibonacci/rosalind_fibo.txt";
        String pathOut = "src/Fibonacci/result_fibo.txt";
        try (FileReader fileReader = new FileReader(pathIn);
             FileWriter fileWriter = new FileWriter(pathOut)) {
            Scanner scanner = new Scanner(fileReader);
            int a = scanner.nextInt();
            fileWriter.write(String.valueOf(numFib(a)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
