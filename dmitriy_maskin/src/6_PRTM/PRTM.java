package PRTM;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class PRTM {
    private static final String FILE_NAME = "prtm_input.txt";
    private static final String FILE_PATH = "src/PRTM/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        String s = Utils.readFromFile(FILE_PATH).get(0);

        System.out.println(String.format("%.3f", PRTM.strTotalWeight(s)));
    }

    static HashMap<String, Double> monoisotopicTable;

    public static double strTotalWeight(String s) {
        createTable();
        String symbol;
        Double weight = 0.0;
        for (int i = 0; i < s.length(); i ++) {
            symbol = String.valueOf(s.charAt(i));
            for (Map.Entry<String, Double> entry : monoisotopicTable.entrySet() ) {
                if (entry.getKey().equals(symbol)) {
                    weight += entry.getValue();
                }
            }
        }
        return weight;
    }

    static void createTable() {
        monoisotopicTable = new HashMap<String, Double>();

        monoisotopicTable.put("A", 71.03711);
        monoisotopicTable.put("C", 103.00919);
        monoisotopicTable.put("D", 115.02694);
        monoisotopicTable.put("E", 129.04259);
        monoisotopicTable.put("F", 147.06841);
        monoisotopicTable.put("G", 57.02146);
        monoisotopicTable.put("H", 137.05891);
        monoisotopicTable.put("I", 113.08406);
        monoisotopicTable.put("K", 128.09496);
        monoisotopicTable.put("L", 113.08406);
        monoisotopicTable.put("M", 131.04049);
        monoisotopicTable.put("N", 114.04293);
        monoisotopicTable.put("P", 97.05276);
        monoisotopicTable.put("Q", 128.05858);
        monoisotopicTable.put("R", 156.10111);
        monoisotopicTable.put("S", 87.03203);
        monoisotopicTable.put("T", 101.04768);
        monoisotopicTable.put("V", 99.06841);
        monoisotopicTable.put("W", 186.07931);
        monoisotopicTable.put("Y", 163.06333);
    }
}
