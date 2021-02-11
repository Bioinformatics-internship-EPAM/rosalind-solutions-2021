import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static List<String> readLinesFromFile(final String filename)
            throws URISyntaxException, IOException{
        URL resource;
        if ((resource = Utils.class.getResource(filename)) != null) {
            return Files.lines(Paths.get(resource.toURI()))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("File '" + filename + "' not found");
        }
    }

    public static List<Pair<String, String>> getFastaRecords(final String filename)
            throws URISyntaxException, IOException, SizeLimitExceededException {
        List<String> lines = readLinesFromFile(filename);

        // Collect all record start indexes
        List<Integer> recIdxs = IntStream.range(0, lines.size())
                .filter(i -> lines.get(i).contains(">")).boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        if (recIdxs.isEmpty())
            throw new SizeLimitExceededException("No FASTA format records in file");

        // Add last string index (end index for last record) to future work
        recIdxs.add(lines.size());

        // Form and return records written as pair
        // of key (record name) and value (DNA)
        return IntStream.range(0, recIdxs.size() - 1)
                .mapToObj(i ->
                        new ImmutablePair<>(
                                lines.get(recIdxs.get(i)).replace(">", ""),
                                StringUtils.join(lines
                                        .subList(recIdxs.get(i) + 1, recIdxs.get(i + 1)), "")))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public static Properties getProperties(final String filename) throws IOException {
        InputStream stream = Utils.class.getClassLoader().getResourceAsStream(filename);
        Properties prop = new Properties();
        prop.load(stream);
        return prop;
    }

    public static long hammingDistance(final String DNA1, final String DNA2) {
        return IntStream.range(0, DNA1.length())
                .filter(i -> DNA1.charAt(i) != DNA2.charAt(i))
                .count();
    }
}
