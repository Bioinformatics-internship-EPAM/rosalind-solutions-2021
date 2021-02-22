package CountInv;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountInv {

    public static long countInv(int n, int[] arr) {
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while (j < n) {
                if (arr[i] > arr[j]) {
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/CountInv/rosalind_inv.txt";
        String pathOut = "src/CountInv/result_inv.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i < n) {
            arr[i] = scanner.nextInt();
            i++;
        }
        fileWriter.write(String.valueOf(countInv(n, arr)));
        fileReader.close();
        fileWriter.close();
    }
}
