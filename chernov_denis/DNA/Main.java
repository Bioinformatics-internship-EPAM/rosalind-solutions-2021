package DNA;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int i;
        long A = 0;
        long G = 0;
        long C = 0;
        long T = 0;
        try (FileInputStream fileInputStream = new FileInputStream("src/DNA/rosalind_dna(1).txt")) {
            while ((i = fileInputStream.read()) != -1) {
                switch (i) {
                    case 'A' -> A++;
                    case 'G' -> G++;
                    case 'C' -> C++;
                    case 'T' -> T++;
                }
            }
        }
        System.out.printf("%d %d %d %d", A, C, G, T);
    }
}