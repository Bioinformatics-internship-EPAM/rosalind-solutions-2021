import java.nio.file.Paths;
import java.util.Map;

public class ComplementingStrandOfDNA {
    public static void main(String[] args) throws Exception {
        final String datasetStr = DatasetReader.readFileIntoString(Paths.get("/tmp/rosalind_revc.txt"));
        final String reversedDNA = makeReverseComplement(datasetStr);
        System.out.printf("%s", reversedDNA);
    }

    public static String makeReverseComplement(final String dna) {
        Map<Character, Character> complements = Map.of(
                'A', 'T',
                'C', 'G',
                'G', 'C',
                'T', 'A'
        );
        StringBuilder result = new StringBuilder();
        dna.chars().forEach(c -> result.append(complements.getOrDefault((char) c, (char) c)));
        return result.reverse().toString();
    }
}
