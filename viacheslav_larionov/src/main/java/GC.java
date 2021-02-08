import java.util.HashMap;

public class GC {

    // Computing GC Content
    public static void main(String[] args) {
        HashMap<String, String> fastaRecordsMap = Utils.getFastaRecords("gc.txt");

        String recKey = "";
        double maxPercentageOfGC = 0;

        for (String key : fastaRecordsMap.keySet()) {
            String dna = fastaRecordsMap.get(key);
            long countOfGC = dna.chars().filter(ch -> ch == 'C' || ch == 'G').count();
            double percentageOfGC = (double) countOfGC / dna.length() * 100;

            if (percentageOfGC > maxPercentageOfGC) {
                recKey = key;
                maxPercentageOfGC = percentageOfGC;
            }
        }

        System.out.format("%s\n%s", recKey, maxPercentageOfGC);
    }
}
