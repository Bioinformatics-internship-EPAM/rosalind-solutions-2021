import java.util.ArrayList;
import java.util.List;

public class Task10 {
    private int permutationsAmount = 0;
    private final List<String> permutations = new ArrayList<>();

    public void enumerateGeneOrders(final int genesNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= genesNumber; i++) {
            stringBuilder.append(i);
        }
        permutation(stringBuilder.toString());
        System.out.println(permutationsAmount);
        for(String permutation: permutations) {
            stringBuilder.setLength(0);
            for (int i = 0; i < permutation.length(); i++) {
                stringBuilder.append(permutation.charAt(i));
                stringBuilder.append(" ");
            }
            System.out.println(stringBuilder.toString());
        }
    }

    private void permutation(final String str) {
        permutation("", str);
    }

    private void permutation(String prefix, String str) {
        final int n = str.length();
        if (n == 1) {
            setPermutationsAmount(getPermutationsAmount() + 1);
            permutations.add(prefix + str);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    public int getPermutationsAmount() {
        return permutationsAmount;
    }

    public void setPermutationsAmount(int permutationsAmount) {
        this.permutationsAmount = permutationsAmount;
    }
}
