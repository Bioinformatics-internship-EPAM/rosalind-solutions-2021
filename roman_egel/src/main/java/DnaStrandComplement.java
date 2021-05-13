import java.util.Map;
import java.util.stream.Collectors;

public class DnaStrandComplement {
    private static final Map<Character, Character> REPLACEMENT = Map.of('A', 'T', 'T', 'A', 'C', 'G', 'G', 'C');

    public static String reverseComplement(String dna) {
        StringBuilder sb = new StringBuilder();
        char[] chars = dna.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(REPLACEMENT.get(chars[i]));
        }

        return sb.toString();
    }
}
