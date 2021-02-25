import java.io.FileReader;
import java.util.Scanner;

public class MendelsFirstLaw {
    public static void main(String[] args) throws Exception {
        try (Scanner s = new Scanner(new FileReader("/tmp/rosalind_iprb.txt"))) {
            final double dominant = s.nextDouble();
            final double hetero = s.nextDouble();
            final double recessive = s.nextDouble();
            final double probabilityOfDominant = countProbabilityOfDominant(dominant, hetero, recessive);
            System.out.printf("%f", probabilityOfDominant);
        }
    }

    public static double countProbabilityOfDominant(final double k, final double m, final double n) {
        final double sum = k + m + n;
        // Count probabilities that if two organisms of type produce recessive
        final double twoRecessive = (n/sum) * ((n - 1)/(sum - 1));
        final double twoHetero = 0.25 * ((m/sum) * ((m - 1)/(sum - 1)));
        final double heteroRecessive = 0.5 * ((m/sum) * (n/(sum - 1)) + (n/sum) * (m/(sum - 1)));

        return 1 - (twoRecessive + twoHetero + heteroRecessive);
    }
}
