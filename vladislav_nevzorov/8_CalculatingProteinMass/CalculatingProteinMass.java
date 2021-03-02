package my.rosalind;

import java.util.*;

public class CalculatingProteinMass {
    public double exec(String protein) {
        var massTable = getMassTable();

        double mass = 0;
        for (int i = 0; i < protein.length(); i++) {
            var symbol = protein.charAt(i);
            var symbolMass = massTable.get(symbol);
            mass += symbolMass;
        }

        return mass;
    }

    private Map<Character, Double> getMassTable() {
        var map = new HashMap<Character, Double>();

        var table = "A   71.03711\n" +
                "C   103.00919\n" +
                "D   115.02694\n" +
                "E   129.04259\n" +
                "F   147.06841\n" +
                "G   57.02146\n" +
                "H   137.05891\n" +
                "I   113.08406\n" +
                "K   128.09496\n" +
                "L   113.08406\n" +
                "M   131.04049\n" +
                "N   114.04293\n" +
                "P   97.05276\n" +
                "Q   128.05858\n" +
                "R   156.10111\n" +
                "S   87.03203\n" +
                "T   101.04768\n" +
                "V   99.06841\n" +
                "W   186.07931\n" +
                "Y   163.06333 ";

        var rows = table.split("\n");
        for (var row : rows) {
            var tokens = new ArrayList<String>(Arrays.asList(row.split(" ")));
            tokens.removeAll(Arrays.asList(""));

            String symbol = tokens.get(0);
            Double mass = Double.parseDouble(tokens.get(1));

            if (symbol != null) {
                map.put(symbol.charAt(0), mass);
            }
        }

        return map;
    }
}
