import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class DNANucleicCounter {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Filename as input argument expected");
            return;
        }

        String filename = args[0];
        String content;

        try {
            content = Files.readString(Path.of(filename), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            System.err.println("Cannot find " + filename + " in resources");
            return;
        }

        Map<Character, Integer> counter = new HashMap<>();
        counter.put('A', 0);
        counter.put('C', 0);
        counter.put('G', 0);
        counter.put('T', 0);

        for (char c: content.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                Integer currentNumber = counter.get(c);
                if (currentNumber == null) {
                    System.err.println("Invalid nucleobase detected: " + c);
                    return;
                }
                counter.put(c, currentNumber + 1);
            }
        }

        System.out.println(counter.get('A') + " " + counter.get('C') + " " + counter.get('G') + " " + counter.get('T'));
    }
}
