import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RabbitsAndRecurrenceRelations {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(new FileReader("/tmp/rosalind_fib.txt"))) {
            final int n = s.nextInt();
            final int k = s.nextInt();
            final long amountOfRabbitPairs = countRabbitPairs(n, k);
            System.out.printf("%d", amountOfRabbitPairs);
        } catch (FileNotFoundException e) {
            System.out.println("Wrong directory to file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long countRabbitPairs(final int n, final int k) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return k;
        }

        final long firstGen = countRabbitPairs(n - 1, k);
        final long secondGen = countRabbitPairs(n - 2, k);

        if (n <= 4) {
            return (firstGen + secondGen);
        }

        return (firstGen + (secondGen * k));
    }
}
