package Lab1;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/Lab1/rosalind_dna(1).txt");
        int i;
        long A = 0;
        long G = 0;
        long C = 0;
        long T = 0;
        while((i=fileInputStream.read())!= -1) {
            switch (i) {
                case 'A' -> A++;
                case 'G' -> G++;
                case 'C' -> C++;
                case 'T' -> T++;
            }
        }
        System.out.printf("%d %d %d %d", A, C, G, T);
    }
}