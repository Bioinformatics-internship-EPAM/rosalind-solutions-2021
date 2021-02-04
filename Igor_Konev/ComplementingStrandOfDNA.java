import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ComplementingStrandOfDNA {
    public static void main(String[] args) {
        try (InputStream dataset = new FileInputStream("/tmp/rosalind_revc.txt")) {
            final String datasetStr = DatasetReader.readFileIntoString(dataset);
            final String reversedDNA = makeReverseComplement(datasetStr);
            System.out.printf("%s", reversedDNA);
        } catch (FileNotFoundException e) {
            System.out.println("Wrong directory to file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't read file into String: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String makeReverseComplement(final String dna) {
        final StringBuilder reversedSymbols = new StringBuilder();
        for(int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'A': {
                    reversedSymbols.append('T');
                    break;
                }
                case 'C': {
                    reversedSymbols.append('G');
                    break;
                }
                case 'G': {
                    reversedSymbols.append('C');
                    break;
                }
                case 'T': {
                    reversedSymbols.append('A');
                    break;
                }
            }
        }
        return reversedSymbols.reverse().toString();
    }
}
