package BinarySearch;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearch {

    public static int binSearch(int[] array, int key, int left, int right) {
        int i = (left + right) / 2;
        if (left > right)
            return -1;
        if (key > array[i])
            return binSearch(array, key, i + 1, right);
        else if (key < array[i])
            return binSearch(array, key, left, i - 1);
        return i + 1;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/BinarySearch/rosalind_bins.txt";
        String pathOut = "src/BinarySearch/result_bins.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i = 0;
        int[] arr = new int[n];
        while (i < n) {
            arr[i] = scanner.nextInt();
            i++;
        }
        i = 0;
        while (i < m) {
            int key = scanner.nextInt();
            int res = binSearch(arr, key, 0, n - 1);
            fileWriter.write(res + " ");
            i++;
        }
        fileReader.close();
        fileWriter.close();
    }
}

