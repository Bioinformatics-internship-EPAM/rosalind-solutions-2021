package MergeArrays;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class MergeArrays {

    public static int[] mergeArray(int n, int[] aArr, int m, int[] bArr) {
        int[] res = new int[n + m];
        int i = 0;
        int ia = 0;
        int ib = 0;
        while (ia < n && ib < m) {
            if (aArr[ia] <= bArr[ib]) {
                res[i] = aArr[ia];
                i++;
                ia++;
            } else {
                res[i] = bArr[ib];
                i++;
                ib++;
            }
        }
        if (ia == n)
            for (; i < n + m; i++) {
                res[i] = bArr[ib];
                ib++;
            }
        else
            for (; i < n + m; i++) {
                res[i] = aArr[ia];
                ia++;
            }
        return res;
    }

    public static void main(String[] args) {
        String pathIn = "src/MergeArrays/rosalind_mer.txt";
        String pathOut = "src/MergeArrays/result_mer.txt";
        try (FileReader fileReader = new FileReader(pathIn);
             FileWriter fileWriter = new FileWriter(pathOut)) {
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
            for (i = 0; i < n + m; i++)
                fileWriter.write(resArr[i] + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
