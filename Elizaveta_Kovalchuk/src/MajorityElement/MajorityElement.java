package MajorityElement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {

    public static int majorElement(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.compute(arr[i], (k, v) -> (map.containsKey(k)) ? v + 1 : 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= n / 2)
                return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/MajorityElement/rosalind_maj.txt";
        String pathOut = "src/MajorityElement/result_maj.txt";
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
            fileWriter.write(majorElement(arr, n) + " ");
        }
        fileReader.close();
        fileWriter.close();
    }
}
