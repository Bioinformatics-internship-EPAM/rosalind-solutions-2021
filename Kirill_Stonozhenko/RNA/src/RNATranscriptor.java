import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class RNATranscriptor {
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

        String rna = dna.replace("T","U");

        System.out.println(rna);
    }
}
