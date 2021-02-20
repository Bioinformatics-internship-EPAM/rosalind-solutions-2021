import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindingAMotifInDNA {
    private static final String FileName = "rosalind_subs.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName);

        var result = getResult(input.get(0), input.get(1));

        System.out.println(result);
    }

    private static String getResult(String first, String second) {
        int index = first.indexOf(second);
        var list = new ArrayList<Integer>();
        while (index >= 0) {
            list.add(index + 1);
            index = first.indexOf(second, index + 1);
        }

        return list.stream().map(Objects::toString).collect(Collectors.joining(" "));
    }
}

