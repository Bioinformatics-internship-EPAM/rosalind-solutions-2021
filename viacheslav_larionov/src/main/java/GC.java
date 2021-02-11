import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class GC {

    private static String filename = "gc.txt";

    public static double getPercentageOfGC(final String dna) {
        long countOfGC = dna.chars().filter(ch -> ch == 'C' || ch == 'G').count();
        return (double) countOfGC / dna.length() * 100;
    }

    // Computing GC Content
    public static void main(String[] args)
            throws IOException, URISyntaxException, SizeLimitExceededException {
        List<Pair<String, String>> fastaRecords = Utils.getFastaRecords(filename);

        // Find record which have max GC content and form pair of key / GC percentage value
        Pair<String, Double> recordWithMaxGC = fastaRecords.stream()
                .map(record -> ImmutablePair.of(record.getKey(), getPercentageOfGC(record.getValue())))
                .max(Comparator.comparingDouble(Pair::getValue))
                .orElseThrow(NoSuchElementException::new);

        System.out.format("%s\n%s\n", recordWithMaxGC.getKey(), recordWithMaxGC.getValue());
    }
}
