import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindingMotifInDNA {
    public static void main(String[] args) throws Exception {
        try (Scanner s = new Scanner(new FileReader("/tmp/rosalind_subs.txt"))) {
            final String dna = s.nextLine();
            final String substringDNA = s.nextLine();
            final List<Integer> occurrences = findSubstringOccurrences(dna, substringDNA);
            System.out.printf("%s", occurrences.toString());
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
