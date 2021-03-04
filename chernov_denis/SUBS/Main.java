package SUBS;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/SUBS/rosalind_subs.txt"), StandardCharsets.UTF_8);
        String dna = lines.get(0);
        String sub = lines.get(1);
        int index = dna.indexOf(sub);
        while (index != -1) {
            index++;
            System.out.printf("%d ", index);
            index = dna.indexOf(sub, index);
        }
    }
}