package HAMM;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/HAMM/rosalind_hamm.txt"), StandardCharsets.UTF_8);
        String dna1 = lines.get(0);
        String dna2 = lines.get(1);
        int N = Math.min(dna1.length(), dna2.length());
        int result = 0;
        for(int i = 0; i < N; i++)
            if (dna1.charAt(i) != dna2.charAt(i))
                result++;
        System.out.print(result);
    }
}
