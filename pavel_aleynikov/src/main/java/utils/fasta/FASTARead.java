package utils.fasta;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for reading data from FASTA file
 */
public class FASTARead {

    /**
     * Read data from FASTA file
     * @param path - path to file
     * @return - list of {@link FASTAItem} read from file
     */
    public static List<FASTAItem> readAllFromFile(Path path) throws IOException {
        List<FASTAItem> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String label = null;
            StringBuilder dna = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith(">")) {
                    if (label != null) {
                        result.add(new FASTAItem(label, dna.toString()));
                    }
                    label = line.substring(1);
                    dna = new StringBuilder();
                } else {
                    dna.append(line);
                }
                line = reader.readLine();
            }
            if (label != null) {
                result.add(new FASTAItem(label, dna.toString()));
            }
        }
        return result;
    }

}
