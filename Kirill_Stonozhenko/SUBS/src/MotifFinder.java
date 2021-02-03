import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MotifFinder {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Filename as input argument expected");
            return;
        }

        String filename = args[0];
        String dna;
        String motif;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            dna = reader.readLine();
            motif = reader.readLine();
            if (dna == null || motif == null) {
                throw new IOException("Two DNA strings expected");
            }
        } catch (IOException e) {
            System.err.println("Problems with file reading:");
            e.printStackTrace();
            return;
        }

        StringBuilder result = new StringBuilder();

        int index = dna.indexOf(motif) + 1;
        while(index != 0) {
            result.append(index).append(" ");
            index = dna.indexOf(motif, index) + 1;
        }

        System.out.println(result);
    }
}
