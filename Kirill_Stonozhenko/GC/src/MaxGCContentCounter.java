import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaxGCContentCounter {

    private static List<DNAString> dnaStrings;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Filename as input argument expected");
            return;
        }

        String filename = args[0];
        dnaStrings = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String str = reader.readLine();
            StringBuilder content = new StringBuilder();
            String label = "";
            while (str != null) {
                if (str.startsWith(">")) {
                    String strContent = content.toString();
                    if (strContent.length() != 0) {
                        dnaStrings.add(new DNAString(strContent, label.substring(1)));
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
                dnaStrings.add(new DNAString(strContent, label));
            } else {
                System.err.println("Empty file");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Problems with file reading:");
            e.printStackTrace();
            return;
        }

        double maxGC = 0;
        DNAString maxGCdna = new DNAString();

        for (DNAString dna: dnaStrings) {
            double currentGC = dna.evaluateGCContent();
            if (currentGC > maxGC) {
                maxGCdna = dna;
                maxGC = currentGC;
            }
        }

        System.out.println(maxGCdna.getName() + "\n" + 100 * maxGC);
    }
}
