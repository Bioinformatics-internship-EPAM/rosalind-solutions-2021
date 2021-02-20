import java.util.HashMap;

public class CountingPointMutations {
    private static final String FileName = "rosalind_hamm.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName);

        var result = getResult(input.get(0), input.get(1));

        System.out.println(result);
    }

    private static int getResult(String first, String second) {
        int count = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
