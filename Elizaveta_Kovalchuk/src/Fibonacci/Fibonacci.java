package Fibonacci;

import java.io.*;
import java.util.Scanner;

public class Fibonacci {

    public static int numFib(int a) throws Exception {
        if (a < 0)
            throw new Exception("Error: number < 0");
        if (a == 0)
            return 0;
        int[] arr = new int[a + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[a];
    }

    public static void main(String[] args) throws Exception {
        String pathIn = "src/Fibonacci/rosalind_fibo.txt";
        String pathOut = "src/Fibonacci/result_fibo.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        int a = scanner.nextInt();
        fileWriter.write(String.valueOf(numFib(a)));
        fileReader.close();
        fileWriter.close();
    }
}
