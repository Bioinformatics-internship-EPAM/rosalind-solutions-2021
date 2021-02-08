import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ReverseComplementor {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Filename as input argument expected");
            return;
        }

        String filename = args[0];
        String dna;

        try {
            dna = Files.readString(Path.of(filename), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            System.err.println("Cannot find " + filename + " in resources");
            return;
        }

        Map<Character, Character> replacements = new HashMap<>();
        replacements.put('A', 'T');
        replacements.put('T', 'A');
        replacements.put('C', 'G');
        replacements.put('G', 'C');

        String reversedDna = new StringBuilder(dna).reverse().toString();

        StringBuilder complementDna = new StringBuilder();
        for (char c: reversedDna.toCharArray()) {
            complementDna.append(replacements.get(c));
        }

        System.out.println(complementDna);
    }
}
