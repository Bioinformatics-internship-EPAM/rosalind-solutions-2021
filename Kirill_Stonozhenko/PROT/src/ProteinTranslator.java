import java.io.*;
import java.util.Properties;

public class ProteinTranslator {

    private static final String TRANSLATION_TABLE_FILENAME = "resources/rna_codon_table.dsv";
    private static final Properties TRANSLATION_TABLE = readTranslationTable();

    private static final int CODON_LENGTH = 3;

    private static Properties readTranslationTable() {
        Properties table = new Properties();
        try (InputStream input = new FileInputStream(TRANSLATION_TABLE_FILENAME)) {
            table.load(input);
        } catch (IOException e) {
            System.err.println("Problems with " + TRANSLATION_TABLE_FILENAME + " reading:");
            e.printStackTrace();
        }
        return table;
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
            if (dna.length() % CODON_LENGTH != 0) {
                System.err.println("Chains of nucleic triplets expected");
                return;
            }
        } catch (IOException e) {
            System.err.println("Problems with file reading:");
            e.printStackTrace();
            return;
        }

        StringBuilder protein = new StringBuilder();

        for (int i = 0; i < dna.length(); i += CODON_LENGTH) {
            String aminoacid = (String) TRANSLATION_TABLE.get(dna.substring(i, i + CODON_LENGTH));
            if (aminoacid != null) {
                if (aminoacid.equals("Stop")) {
                    break;
                }
                protein.append(aminoacid);
            } else {
                System.err.println("Unacceptable nucleic triplet: " + TRANSLATION_TABLE.get(dna.substring(i, i + CODON_LENGTH)));
            }
        }

        System.out.println(protein);
    }
}
