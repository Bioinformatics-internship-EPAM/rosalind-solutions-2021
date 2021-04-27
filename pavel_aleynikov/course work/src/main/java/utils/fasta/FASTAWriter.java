package utils.fasta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Class for writing data from FASTA file
 */
public class FASTAWriter {

    private static final int LINE_LENGTH = 70;

    /**
     * Writing data from FASTA file
     *
     * @param path       - path to file
     * @param writeItems - write data
     */
    public static void writeAllToFile(Path path, List<FASTAItem> writeItems) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (FASTAItem item : writeItems) {
                writer.write(">" + item.getLabel());
                writer.newLine();
                for (int i = 0; i < item.getSequence().length(); i = i + LINE_LENGTH) {
                    writer.write(item.getSequence().substring(i, Math.min(i + LINE_LENGTH, item.getSequence().length())));
                    writer.newLine();
                }
            }
        }
    }

}
