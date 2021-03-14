//Dataset at the moment:
//6
package BioinformStrong.PERM;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void swap(int[] input, int a, int b) {
        int buffer = input[a];
        input[a] = input[b];
        input[b] = buffer;
    }

    public static void printArray(int[] input, FileWriter writer) {
        StringBuilder lineToWrite = new StringBuilder();
        try {
            for (int j : input) {
                lineToWrite.append(j).append(' ');
            }
            System.out.println(lineToWrite);
            writer.write(lineToWrite.toString() + '\n');
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("output.txt", StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        int n = 6;
        int[] indexes = new int[n];
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i+1;
        }
        Arrays.fill(indexes, 0);

        //the first permutation
        printArray(elements, writer);
        int count = 1;

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                printArray(elements, writer);
                count++;
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }
        System.out.println(count);
        try {
            if (writer != null) {
                writer.write(Integer.toString((char)count));
                writer.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
