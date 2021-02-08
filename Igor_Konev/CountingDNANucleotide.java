import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDNANucleotide {
    public static void main(String[] args) throws Exception {
        final String datasetStr = DatasetReader.readFileIntoString(Paths.get("/tmp/rosalind_dna.txt"));
        final Map<String, Long> nucleotidesCount = countNucleotides(datasetStr);
        System.out.println(nucleotidesCount.toString());
    }

    public static Map<String, Long> countNucleotides(final String str) {
        return str.toUpperCase()
                .codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
