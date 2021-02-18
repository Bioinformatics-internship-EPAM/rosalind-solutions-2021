package TwoSum;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TwoSum {

    public static ArrayList<Integer> twoSum (int n, int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] == -1 * arr[j]) {
                    res.add(++i);
                    res.add(++j);
                    return res;
                }
        res.add(-1);
        return res;
    }

    public static void main(String[] args) {
        String pathIn = "src/TwoSum/rosalind_2sum.txt";
        String pathOut = "src/TwoSum/result_2sum.txt";
        try (FileReader fileReader = new FileReader(pathIn);
             FileWriter fileWriter = new FileWriter(pathOut)) {
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
                ArrayList<Integer> res = twoSum(n, arr);
                Iterator<Integer> iterator = res.iterator();
                while (iterator.hasNext()) {
                    fileWriter.write(iterator.next().toString() + " ");
                }
                fileWriter.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
