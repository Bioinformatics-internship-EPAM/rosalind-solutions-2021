import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DNANucleicCounter {

    private static final int ALPHABET_LENGTH = 4;

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

        int[] counter = new int[ALPHABET_LENGTH];

        for (char c: content.toCharArray()) {
            switch (c) {
                case 'A' :
                    counter[0]++;
                    break;
                case 'C' :
                    counter[1]++;
                    break;
                case 'G' :
                    counter[2]++;
                    break;
                case 'T' :
                    counter[3]++;
                    break;
                default:
                    if (!Character.isWhitespace(c)) {
                        System.err.println("Invalid nucleobase detected: " + c);
                        return;
                    }
            }
        }

        System.out.println(counter[0] + " " + counter[1] + " " + counter[2] + " " + counter[3]);
    }
}
