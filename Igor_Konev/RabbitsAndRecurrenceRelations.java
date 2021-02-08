import java.io.FileReader;
import java.util.Scanner;

public class RabbitsAndRecurrenceRelations {
    public static void main(String[] args) throws Exception {
        try (Scanner s = new Scanner(new FileReader("/tmp/rosalind_fib.txt"))) {
            final int n = s.nextInt();
            final int k = s.nextInt();
            final long amountOfRabbitPairs = countRabbitPairs(n, k);
            System.out.printf("%d", amountOfRabbitPairs);
        }
    }

    public static long countRabbitPairs(final int amountOfMonths, final int offspring) {
        if (amountOfMonths == 1) {
            return 1;
        }

        if (amountOfMonths == 2) {
            return offspring;
        }

        final long firstGen = countRabbitPairs(amountOfMonths - 1, offspring);
        final long secondGen = countRabbitPairs(amountOfMonths - 2, offspring);

        if (amountOfMonths <= 4) {
            return (firstGen + secondGen);
        }

        return (firstGen + (secondGen * offspring));
    }
}
