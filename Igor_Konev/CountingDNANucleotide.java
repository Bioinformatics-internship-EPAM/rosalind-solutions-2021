import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CountingDNANucleotide {
    public static void main(String[] args) {
        try (InputStream dataset = new FileInputStream("/tmp/rosalind_dna.txt")) {
            final String datasetStr = DatasetReader.readFileIntoString(dataset);
            final Map<CharSequence, Integer> nucleotidesCount = countNucleotides(datasetStr);
            System.out.println(nucleotidesCount.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Wrong directory to file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't read file into String: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<CharSequence, Integer> countNucleotides(final String str) {
        final Map<CharSequence, Integer> nucleotides = new HashMap<>();
        final String upperStr = str.toUpperCase();

        for(int i = 0; i < upperStr.length(); i++) {
            switch (upperStr.charAt(i)) {
                case 'A': {
                    nucleotides.merge("A", 1, Integer::sum);
                    break;
                }
                case 'C': {
                    nucleotides.merge("C", 1, Integer::sum);
                    break;
                }
                case 'G': {
                    nucleotides.merge("G", 1, Integer::sum);
                    break;
                }
                case 'T': {
                    nucleotides.merge("T", 1, Integer::sum);
                    break;
                }
            }
        }
        return nucleotides;
    }
}
