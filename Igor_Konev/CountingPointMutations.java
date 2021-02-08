import java.io.FileReader;
import java.util.Scanner;

public class CountingPointMutations {
    public static void main(String[] args) throws Exception {
        try (Scanner s = new Scanner(new FileReader("/tmp/rosalind_hamm.txt"))) {
            final String dna1 = s.nextLine();
            final String dna2 = s.nextLine();
            final int hammingDistance = countHammingDistance(dna1, dna2);
            System.out.printf("%d", hammingDistance);
        }
    }

    public static int countHammingDistance(final String dna1, final String dna2) {
        int i = 0, count = 0;
        while (i < dna1.length())
        {
            if (dna1.charAt(i) != dna2.charAt(i))
                count++;
            i++;
        }
        return count;
    }
}
