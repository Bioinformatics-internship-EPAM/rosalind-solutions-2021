import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TranscribingDNAIntoRNA {
    public static void main(String[] args) {
        try (InputStream dataset = new FileInputStream("/tmp/rosalind_rna.txt")) {
            final String datasetStr = DatasetReader.readFileIntoString(dataset);
            final String rna = transcribeDNAToRNA(datasetStr);
            System.out.printf("%s", rna);
        } catch (FileNotFoundException e) {
            System.out.println("Wrong directory to file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't read file into String: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String transcribeDNAToRNA(final String dna) {
        return dna.replace('T', 'U');
    }
}
