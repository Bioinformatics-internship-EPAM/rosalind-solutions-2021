package InsertionSort;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class InsertionSort {

    public static int kolSwap(int n, int arr[]) {
        int kol = 0;
        for (int i = 1; i < n; i++) {
            int k = i;
            while (k > 0 && arr[k] < arr[k - 1]) {
                int temp = arr[k];
                arr[k] = arr[k - 1];
                arr[k - 1] = temp;
                kol++;
                k--;
            }
        }
        return kol;
    }

    public static void main(String[] args) {
        String pathIn = "src/InsertionSort/rosalind_ins.txt";
        String pathOut = "src/InsertionSort/result_ins.txt";
        try (FileReader fileReader = new FileReader(pathIn);
             FileWriter fileWriter = new FileWriter(pathOut)) {
            Scanner scanner = new Scanner(fileReader);
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int i = 0;
            while (i < n) {
                arr[i] = scanner.nextInt();
                i++;
            }
            fileWriter.write(String.valueOf(kolSwap(n, arr)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
