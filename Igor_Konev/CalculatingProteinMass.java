import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculatingProteinMass {
    private final static Map<Character, Double> monoisotopicMass;
    static {
        monoisotopicMass = Stream.of(new Object[][]{
                {'A', 71.03711},  {'C', 103.00919},
                {'D', 115.02694}, {'E', 129.04259},
                {'F', 147.06841}, {'G', 57.02146},
                {'H', 137.05891}, {'I', 113.08406},
                {'K', 128.09496}, {'L', 113.08406},
                {'M', 131.04049}, {'N', 114.04293},
                {'P', 97.05276},  {'Q', 128.05858},
                {'R', 156.10111}, {'S', 87.03203},
                {'T', 101.04768}, {'V', 99.06841},
                {'W', 186.07931}, {'Y', 163.06333},
        }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Double) data[1]));
    }

    public static void main(String[] args) {
        try (InputStream dataset = new FileInputStream("/tmp/rosalind_prtm.txt")) {
            final String datasetStr = DatasetReader.readFileIntoString(dataset);
            final double proteinMass = countProteinMass(datasetStr);
            System.out.printf("%f", proteinMass);
        } catch (FileNotFoundException e) {
            System.out.println("Wrong directory to file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't read file into String: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double countProteinMass(final String protein) {
        double proteinMass = 0.0;

        for (int i = 0; i < protein.length(); i++) {
            proteinMass += monoisotopicMass.getOrDefault(protein.charAt(i), 0.0);
        }

        return proteinMass;
    }
}
