import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindingMotifInDNA {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(new FileReader("/tmp/rosalind_subs.txt"))) {
            final String dna = s.nextLine();
            final String substringDNA = s.nextLine();
            final List<Integer> occurrences = findSubstringOccurrences(dna, substringDNA);
            System.out.printf("%s", occurrences.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Wrong directory to file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> findSubstringOccurrences(final String str, final String substring) {
        final LinkedList<Integer> occurrences = new LinkedList<>();

        int index = 0;
        while (true) {
            index = str.indexOf(substring, index);
            if (index != -1) {
                // Add index + 1 because in the task numeration starts with 1
                occurrences.add(index + 1);
                index += 1;
            } else {
                break;
            }
        }

        return occurrences;
    }
}
