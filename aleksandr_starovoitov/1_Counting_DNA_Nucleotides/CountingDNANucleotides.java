import java.util.HashMap;
import java.util.Map;

public class CountingDNANucleotides {
    private static final String FileName = "rosalind_dna.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName).get(0);

        var result = getResult(input);

        System.out.println(result);
    }

    private static String getResult(String input) {
        var charCount = new HashMap<>(Map.of(
            'A', 0,
            'C', 0,
            'G', 0,
            'T', 0
        ));

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int currentCount = charCount.get(c);
            charCount.put(c, currentCount + 1);
        }

        return String.format("%d %d %d %d", charCount.get('A'), charCount.get('C'), charCount.get('G'), charCount.get('T'));
    }
}
