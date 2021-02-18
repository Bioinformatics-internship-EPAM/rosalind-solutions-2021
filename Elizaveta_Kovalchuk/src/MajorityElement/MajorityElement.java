package MajorityElement;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {

    public static int majorElement(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int value = map.remove(arr[i]);
                map.put(arr[i], value + 1);
            } else
                map.put(arr[i], 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() >= n / 2)
                return entry.getKey();
        return -1;
    }

    public static void main(String[] args) {
        String pathIn = "src/MajorityElement/rosalind_maj.txt";
        String pathOut = "src/MajorityElement/result_maj.txt";
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
                fileWriter.write(String.valueOf(majorElement(arr, n)) + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
