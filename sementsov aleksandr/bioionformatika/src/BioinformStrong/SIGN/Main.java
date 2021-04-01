package BioinformStrong.SIGN;

import java.io.IOException;
import java.util.Arrays;
import BioinformStrong.Services.*;

public class Main {

    public static void swap(int[] input, int a, int b) {
        input[a] ^= input[b];
        input[b] ^= input[a];
        input[a] ^= input[b];
    }

    public static void main(String[] args) {

        // dataset
        int n = 4;

        int[] indexes = new int[n];
        int[] elements = new int[n];
        TranslationMap translationMap = new TranslationMap(n);

        // calculate number of permutations
        try {
            int counter = translationMap.getNumberPermutations(n);

            // now, execute same permutation
            Arrays.fill(indexes, 0);
            for (int i = 0; i < elements.length; i++) {
                elements[i] = i + 1;
            }

            //the first permutation
            int count = 0;
            count = translationMap.getMap(elements, count);

            int i = 0;
            while (i < n) {
                if (indexes[i] < i) {
                    swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                    count = translationMap.getMap(elements, count);
                    indexes[i]++;
                    i = 0;
                }
                else {
                    indexes[i] = 0;
                    i++;
                }
            }
            System.out.println(counter);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("\n\n\t->\tProblem in calculating number of permutation (look up).");
        }
    }
}
