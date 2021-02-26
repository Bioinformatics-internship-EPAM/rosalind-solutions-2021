package DoubleDegreeArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static DegreeArray.DegreeArray.degreeArr;

public class DoubleDegreeArray {

    public static int[] doubleDegArr(int n, int m, int[][] arr) {
        int[] degrees = degreeArr(n, m, arr);
        int[] res = new int[n];
        for (int i = 0; i < m; i++) {
            res[arr[i][0] - 1] += degrees[arr[i][1] - 1];
            res[arr[i][1] - 1] += degrees[arr[i][0] - 1];
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/DoubleDegreeArray/rosalind_ddeg.txt";
        String pathOut = "src/DoubleDegreeArray/result_ddeg.txt";
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
        int[] res = doubleDegArr(n, m, arr);
        for (i = 0; i < n; i++) {
            fileWriter.write(res[i] + " ");
        }
        fileReader.close();
        fileWriter.close();
    }
}
