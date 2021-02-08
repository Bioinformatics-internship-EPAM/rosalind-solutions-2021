import java.nio.file.Paths;
import java.util.Map;

import static java.util.Map.entry;

public class CalculatingProteinMass {
    private final static Map<Character, Double> monoisotopicMass = Map.ofEntries(
            entry('A', 71.03711), entry('C', 103.00919),
            entry('D', 115.02694), entry('E', 129.04259),
            entry('F', 147.06841), entry('G', 57.02146),
            entry('H', 137.05891), entry('I', 113.08406),
            entry('K', 128.09496), entry('L', 113.08406),
            entry('M', 131.04049), entry('N', 114.04293),
            entry('P', 97.05276), entry('Q', 128.05858),
            entry('R', 156.10111), entry('S', 87.03203),
            entry('T', 101.04768), entry('V', 99.06841),
            entry('W', 186.07931), entry('Y', 163.06333)
    );

    public static void main(String[] args) throws Exception {
        final String datasetStr = DatasetReader.readFileIntoString(Paths.get("/tmp/rosalind_prtm.txt"));
        final double proteinMass = countProteinMass(datasetStr);
        System.out.printf("%f", proteinMass);
    }

    public static double countProteinMass(final String protein) {
        return protein.chars()
                .mapToDouble(c -> monoisotopicMass.getOrDefault((char) c, 0.0))
                .sum();
    }
}
