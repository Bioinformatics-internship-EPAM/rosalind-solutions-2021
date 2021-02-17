import java.util.HashMap;

public class CalculatingProteinMass {
    private static final String FileName = "rosalind_prtm.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName).get(0);

        var result = getResult(input);

        System.out.println((double) Math.round(result * 1000) / 1000);
    }

    private static double getResult(String input) {
        var table = getTable();

        double sum = 0;
        for (int i = 0; i < input.length(); i++) {
           sum += table.get(input.charAt(i));
        }

        return sum;
    }

    private static HashMap<Character, Double> getTable() {
        var table = new HashMap<Character, Double>();
        table.put('A', 71.03711);
        table.put('C', 103.00919);
        table.put('D', 115.02694);
        table.put('E', 129.04259);
        table.put('F', 147.06841);
        table.put('G', 57.02146);
        table.put('H', 137.05891);
        table.put('I', 113.08406);
        table.put('K', 128.09496);
        table.put('L', 113.08406);
        table.put('M', 131.04049);
        table.put('N', 114.04293);
        table.put('P', 97.05276);
        table.put('Q', 128.05858);
        table.put('R', 156.10111);
        table.put('S', 87.03203);
        table.put('T', 101.04768);
        table.put('V', 99.06841);
        table.put('W', 186.07931);
        table.put('Y', 163.06333);

        return table;
    }
}

