//Dataset at the moment:
//6
package com.company;

public class Main {

    public static void swap(int[] input, int a, int b) {
        int buffer = input[a];
        input[a] = input[b];
        input[b] = buffer;
    }

    public static void printArray(int[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(" "); //separating
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[] indexes = new int[n];
        int[] elements = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        //the first permutation
        printArray(elements);
        int count = 1;

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                printArray(elements);
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
    }
}