import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumeratingGeneOrders {
    private static final String FileName = "rosalind_perm.txt";
    private static int count = 0;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName);

        getResult(input.get(0));

        System.out.print(count);
        System.out.println(sb.toString());
    }

    private static void getResult(String input) {
        var count = Integer.valueOf(input);
        var numbers = Stream.iterate(1, n -> n + 1)
                .limit(count)
                .collect(Collectors.toList());

        permute(numbers, 0);
    }

    private static void permute(List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            count++;
            sb.append("\n");
            sb.append(arr.stream().map(Objects::toString).collect(Collectors.joining(" ")));
        }
    }
}
