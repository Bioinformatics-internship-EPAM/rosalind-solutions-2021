import java.util.HashMap;

public class ComplementingAStrandOfDNA {
    private static final String FileName = "rosalind_revc.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName);

        var result = getResult(input);

        System.out.println(result);
    }

    private static String getResult(String input) {
        var complements = new HashMap<Character, Character>();
        complements.put('A', 'T');
        complements.put('T', 'A');
        complements.put('C', 'G');
        complements.put('G', 'C');

        var sb = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(complements.get(input.charAt(i)));
        }

        return sb.toString();
    }
}
