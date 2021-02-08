import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaxGCContentCounter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Filename as input argument expected");
            return;
        }

        String filename = args[0];
        double maxGC = 0;
        String maxGCdnaLabel = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String str = reader.readLine();
            StringBuilder content = new StringBuilder();
            String label = "";
            while (str != null) {
                if (str.startsWith(">")) {
                    String strContent = content.toString();
                    if (strContent.length() != 0) {
                        double currentGC = evaluateGCContent(strContent);
                        if (currentGC > maxGC) {
                            maxGCdnaLabel = label.substring(1);
                            maxGC = currentGC;
                        }
                    }
                    label = str;
                    content = new StringBuilder();
                } else {
                    content.append(str);
                }
                str = reader.readLine();
            }
            String strContent = content.toString();
            if (strContent.length() != 0) {
                double currentGC = evaluateGCContent(strContent);
                if (currentGC > maxGC) {
                    maxGCdnaLabel = label.substring(1);
                    maxGC = currentGC;
                }
            } else {
                System.err.println("Empty file");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Problems with file reading:");
            e.printStackTrace();
            return;
        }

        System.out.println(maxGCdnaLabel + "\n" + 100 * maxGC);
    }

    private static double evaluateGCContent(String dna) {
        long countG = dna.chars().filter(ch -> ch == 'G').count();
        long countC = dna.chars().filter(ch -> ch == 'C').count();
        return (double)(countC + countG) / dna.length();
    }
}
