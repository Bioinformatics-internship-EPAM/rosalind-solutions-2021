import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task6 {
    public static Map<String, Double> monoisotopicMasses;
    //Map.of(); doesn't work for 20 pairs.
    static {
        monoisotopicMasses = new HashMap<>();
        monoisotopicMasses.put("A", 71.03711);
        monoisotopicMasses.put("C", 103.00919);
        monoisotopicMasses.put("D", 115.02694);
        monoisotopicMasses.put("E", 129.04259);
        monoisotopicMasses.put("F", 147.06841);
        monoisotopicMasses.put("G", 57.02146);
        monoisotopicMasses.put("H", 137.05891);
        monoisotopicMasses.put("I", 113.08406);
        monoisotopicMasses.put("K", 128.09496);
        monoisotopicMasses.put("L", 113.08406);
        monoisotopicMasses.put("M", 131.04049);
        monoisotopicMasses.put("N", 114.04293);
        monoisotopicMasses.put("P", 97.05276);
        monoisotopicMasses.put("Q", 128.05858);
        monoisotopicMasses.put("R", 156.10111);
        monoisotopicMasses.put("S", 87.03203);
        monoisotopicMasses.put("T", 101.04768);
        monoisotopicMasses.put("V", 99.06841);
        monoisotopicMasses.put("W", 186.07931);
        monoisotopicMasses.put("Y", 163.06333);
    }

    public static Double calculateProteinMass(final String proteinString) {
        // we can also use stop sequences here, but it's not asked.
        return Stream.of(proteinString.split(""))
                .mapToDouble(monoisotopicMasses::get)
                .sum();
    }
}
