//Dataset at the moment:
package BioinformStrong.DNA;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Main {

    static String getDataSet(String stringWay) throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            return scanner.nextLine();
        }
    }

    public static void main(String[] args) {

        //To load a dataset
        String s = "";
        try {
            s = getDataSet("rosalind-DNA.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        char[] nucleotides = {'A', 'C', 'G', 'T'};
        long freq;

        //To realize the algorithm
        for (char nucleotide : nucleotides) {
            freq = s.chars().filter(ch -> ch == nucleotide).count();
            System.out.printf("%d ", freq);
        }
    }
}
