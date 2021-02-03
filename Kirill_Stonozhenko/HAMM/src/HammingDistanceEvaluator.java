import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HammingDistanceEvaluator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Filename as input argument expected");
            return;
        }

        String filename = args[0];
        String dna1;
        String dna2;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            dna1 = reader.readLine().replaceAll("\\s","");
            dna2 = reader.readLine().replaceAll("\\s","");
            if (dna1 == null || dna2 == null) {
                throw new IOException("Two DNA strings expected");
            }
            if (dna1.length() != dna2.length()) {
                throw new IOException("DNA strings of one length expected");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Problems with file reading:");
            e.printStackTrace();
            return;
        }

        int hammingDistance = 0;

        for (int i = 0; i < dna1.length(); i++) {
            if (dna1.charAt(i) != dna2.charAt(i)) {
                hammingDistance++;
            }
        }

        System.out.println(hammingDistance);
    }
}
