package MergeArrays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeArrays {

    public static int[] mergeArray(int n, int[] aArr, int m, int[] bArr) {
        int[] res = new int[n + m];
        int i = 0;
        int indexArrA = 0;
        int indexArrB = 0;
        while (indexArrA < n && indexArrB < m) {
            if (aArr[indexArrA] <= bArr[indexArrB]) {
                res[i] = aArr[indexArrA];
                i++;
                indexArrA++;
            } else {
                res[i] = bArr[indexArrB];
                i++;
                indexArrB++;
            }
        }
        if (indexArrA == n)
            for (; i < n + m; i++) {
                res[i] = bArr[indexArrB];
                indexArrB++;
            }
        else
            for (; i < n + m; i++) {
                res[i] = aArr[indexArrA];
                indexArrA++;
            }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/MergeArrays/rosalind_mer.txt";
        String pathOut = "src/MergeArrays/result_mer.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int[] aArr = new int[n];
        int i = 0;
        while (i < n) {
            aArr[i] = scanner.nextInt();
            i++;
        }
        int m = scanner.nextInt();
        int[] bArr = new int[m];
        i = 0;
        while (i < m) {
            bArr[i] = scanner.nextInt();
            i++;
        }
        int[] resArr = mergeArray(n, aArr, m, bArr);
        for (i = 0; i < n + m; i++) {
            fileWriter.write(resArr[i] + " ");
        }
        fileReader.close();
        fileWriter.close();
    }
}
