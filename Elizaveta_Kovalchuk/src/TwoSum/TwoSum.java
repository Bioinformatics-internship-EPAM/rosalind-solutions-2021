package TwoSum;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TwoSum {

    public static List<Integer> twoSum(int n, int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == -1 * arr[j]) {
                    res.add(++i);
                    res.add(++j);
                    return res;
                }
            }
        }
        res.add(-1);
        return res;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/TwoSum/rosalind_2sum.txt";
        String pathOut = "src/TwoSum/result_2sum.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int j = 0; j < k; j++) {
            int i = 0;
            while (i < n) {
                arr[i] = scanner.nextInt();
                i++;
            }
            List<Integer> res = twoSum(n, arr);
            fileWriter.write(res.toString()
                    .replace("[", "")
                    .replace(",", "")
                    .replace("]", "") + '\n');
        }
        fileReader.close();
        fileWriter.close();
    }
}
