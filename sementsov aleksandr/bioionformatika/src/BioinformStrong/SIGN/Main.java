//Dataset at the moment:
//6
package BioinformStrong.SIGN;

import java.util.Arrays;

public class Main {

    public static void swap(int[] input, int a, int b) {
        input[a] ^= input[b];
        input[b] ^= input[a];
        input[a] ^= input[b];
    }

    public static void main(String[] args) {
        int n = 3;
        int[] indexes = new int[n];
        int[] elements = new int[n];
        TranslationMap translationMap = new TranslationMap(n);
        Arrays.fill(indexes, 0);
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i + 1;
        }

        MyWriter.goSave();

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
        System.out.println(count);
        MyWriter.quitRosalind();
    }
}
