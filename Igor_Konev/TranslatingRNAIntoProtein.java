import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TranslatingRNAIntoProtein {
    private final static Map<String, String> codonsMap;
    static {
        codonsMap = Stream.of(new String[][]{
                {"UUU", "F"}, {"CUU", "L"}, {"AUU", "I"},
                {"GUU", "V"}, {"UUC", "F"}, {"CUC", "L"},
                {"AUC", "I"}, {"GUC", "V"}, {"UUA", "L"},
                {"CUA", "L"}, {"AUA", "I"}, {"GUA", "V"},
                {"UUG", "L"}, {"CUG", "L"}, {"AUG", "M"},
                {"GUG", "V"}, {"UCU", "S"}, {"CCU", "P"},
                {"ACU", "T"}, {"GCU", "A"}, {"UCC", "S"},
                {"CCC", "P"}, {"ACC", "T"}, {"GCC", "A"},
                {"UCA", "S"}, {"CCA", "P"}, {"ACA", "T"},
                {"GCA", "A"}, {"UCG", "S"}, {"CCG", "P"},
                {"ACG", "T"}, {"GCG", "A"}, {"UAU", "Y"},
                {"CAU", "H"}, {"AAU", "N"}, {"GAU", "D"},
                {"UAC", "Y"}, {"CAC", "H"}, {"AAC", "N"},
                {"GAC", "D"}, {"UAA", "Stop"}, {"CAA", "Q"},
                {"AAA", "K"}, {"GAA", "E"}, {"UAG", "Stop"},
                {"CAG", "Q"}, {"AAG", "K"}, {"GAG", "E"},
                {"UGU", "C"}, {"CGU", "R"}, {"AGU", "S"},
                {"GGU", "G"}, {"UGC", "C"}, {"CGC", "R"},
                {"AGC", "S"}, {"GGC", "G"}, {"UGA", "Stop"},
                {"CGA", "R"}, {"AGA", "R"}, {"GGA", "G"},
                {"UGG", "W"}, {"CGG", "R"}, {"AGG", "R"},
                {"GGG", "G"},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    }

    public static void main(String[] args) {
        try (InputStream dataset = new FileInputStream("/tmp/rosalind_prot.txt")) {
            final String protein = readRNAFromFileAndConvertIntoProtein(dataset);
            System.out.println(protein);
        } catch (FileNotFoundException e) {
            System.out.println("Wrong directory to file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readRNAFromFileAndConvertIntoProtein(final InputStream inputStream)
            throws IOException {
        final StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            char[] codon = new char[3];
            // Read file by three elements to convert them into acid
            while ((br.read(codon, 0, 3)) != -1) {
                final String acid = codonsMap.getOrDefault(String.valueOf(codon), "");
                if (acid.equals("Stop")) {
                    break;
                }
                resultStringBuilder.append(acid);
            }
        }
        return resultStringBuilder.toString();
    }
}
