import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ComputingGCContent {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("/tmp/rosalind_gc.txt"))) {
            final Tuple<String, Double> maxResult = readFASTAAndComputeGCContent(scan);
            System.out.printf("%s\n%f", maxResult.first, maxResult.second);
        } catch (FileNotFoundException e) {
            System.out.println("Wrong directory to file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Tuple<String, Double> readFASTAAndComputeGCContent(final Scanner scan) {
        scan.useDelimiter(Pattern.compile(">"));
        String maxGCPercentageId = "";
        double maxGCPercentage = 0;
        while (scan.hasNext()) {
            // Read one FASTA record with ID and DNA
            final String logicalLine = scan.next();
            // Split by \n. First element should contain ID and the other ones should contain DNA parts
            final String[] realLines = logicalLine.split("\n");
            int dnaLength = 0;
            double countGC = 0;
            for (int i = 1; i < realLines.length; i++) {
                // Sum lengths of DNA parts to compute whole DNA length
                dnaLength += realLines[i].trim().length();
                // Iterate over DNA parts and compute GCs
                for (int j = 0; j < realLines[i].length(); j++) {
                    if (realLines[i].charAt(j) == 'G' || realLines[i].charAt(j) == 'C') {
                        countGC += 1.0;
                    }
                }
            }
            if (dnaLength > 0) {
                final double percentageGC = (countGC /(double) (dnaLength));
                if (percentageGC >= maxGCPercentage) {
                    maxGCPercentage = percentageGC;
                    maxGCPercentageId = realLines[0];
                }
            }
        }
        return new Tuple<>(maxGCPercentageId, maxGCPercentage * 100);
    }
}

class Tuple<K, V> {
    K first;
    V second;

    public Tuple(K first, V second){
        this.first = first;
        this.second = second;
    }
}
