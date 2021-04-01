import java.util.Map;

import static java.util.Map.entry;

public class PRTM {

    private static Map<Character, Double> massMap = Map.ofEntries(
        entry('A', 71.03711),
        entry('C', 103.00919),
        entry('D', 115.02694),
        entry('E', 129.04259),
        entry('F', 147.06841),
        entry('G', 57.02146),
        entry('H', 137.05891),
        entry('I', 113.08406),
        entry('K', 128.09496),
        entry('L', 113.08406),
        entry('M', 131.04049),
        entry('N', 114.04293),
        entry('P', 97.05276),
        entry('Q', 128.05858),
        entry('R', 156.10111),
        entry('S', 87.03203),
        entry('T', 101.04768),
        entry('V', 99.06841),
        entry('W', 186.07931),
        entry('Y', 163.06333)
    );

    public static double calcProteinMass(String proteinStr) {

        double mass = 0;

        for (char c: proteinStr.toCharArray()) {
            mass += massMap.get(c);
        }

        // rounding mass to 3 decimal places
        return (double) Math.round(mass * 1000) / 1000;
    }
}
