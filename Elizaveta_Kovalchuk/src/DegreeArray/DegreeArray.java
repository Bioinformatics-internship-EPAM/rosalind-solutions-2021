package DegreeArray;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DegreeArray {

    public static int[] degreeArr(int n, int m, int[][] arr) {
        int[] res = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                res[arr[i][j] - 1]++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/DegreeArray/rosalind_deg.txt";
        String pathOut = "src/DegreeArray/result_deg.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[m][2];
        int i = 0;
        while (i < m) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            i++;
        }
        int[] res = degreeArr(n, m, arr);
        for (i = 0; i < n; i++)
            fileWriter.write(res[i] + " ");
        fileReader.close();
        fileWriter.close();
    }
}
