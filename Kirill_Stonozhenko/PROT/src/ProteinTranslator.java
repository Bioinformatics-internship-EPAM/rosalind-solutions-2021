import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProteinTranslator {

    private static final String TRANSLATION_TABLE_FILENAME = "resources/rna_codon_table.dsv";
    private static final Map<String, String> TRANSLATION_TABLE;
    static {
        TRANSLATION_TABLE = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(TRANSLATION_TABLE_FILENAME));
            String str = reader.readLine();
            while (str != null) {
                TRANSLATION_TABLE.put(str.substring(0,3), str.substring(4));
                str = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Problems with " + TRANSLATION_TABLE_FILENAME + " reading:");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Filename as input argument expected");
            return;
        }

        String filename = args[0];
        String dna;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            dna = reader.readLine();
            if (dna.length() % 3 != 0) {
                throw new IOException("Chains of nucleic triplets expected");
            }
        } catch (IOException e) {
            System.err.println("Problems with file reading:");
            e.printStackTrace();
            return;
        }

        StringBuilder protein = new StringBuilder();

        for (int i = 0; i < dna.length(); i+=3) {
            String aminoacid = TRANSLATION_TABLE.get(dna.substring(i, i+3));
            if (aminoacid != null) {
                if (aminoacid.equals("Stop")) {
                    break;
                }
                protein.append(aminoacid);
            } else {
                System.err.println("Unacceptable nucleic triplet: " + TRANSLATION_TABLE.get(dna.substring(i, i+3)));
            }
        }

        System.out.println(protein);
    }
}
