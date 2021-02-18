package MergeSort;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class MergeSort {

    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int[] arrTemp = new int[r + 1];
        int k = 0;
        int i = p;
        int j = q + 1;
        while (i <= q && j <= r) {
            if (A[i] < A[j]) {
                arrTemp[k] = A[i];
                i++;
            } else {
                arrTemp[k] = A[j];
                j++;
            }
            k++;
        }
        if (j > r)
            for (; i <= q; i++, k++)
                arrTemp[k] = A[i];
        else for (; j <= r; j++, k++)
            arrTemp[k] = A[j];
        i = 0;
        for (int l = p; l <= r; l++) {
            A[l] = arrTemp[i];
            i++;
        }
    }

    public static void main(String[] args) {
        String pathIn = "src/MergeSort/rosalind_ms.txt";
        String pathOut = "src/MergeSort/result_ms.txt";
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
            mergeSort(arr, 0, n - 1);
            for (i = 0; i < n; i++)
                fileWriter.write(arr[i] + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
