import java.util.HashMap;
import java.util.Map;

public class ComplementingAStrandOfDNA {
    private static final String FileName = "rosalind_revc.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName).get(0);

        var result = getResult(input);

        System.out.println(result);
    }

    private static String getResult(String input) {
        var complements = new HashMap<>(Map.of(
        'A', 'T',
        'T', 'A',
        'C', 'G',
        'G', 'C'
        ));

        var sb = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(complements.get(input.charAt(i)));
        }

        return sb.toString();
    }
}
