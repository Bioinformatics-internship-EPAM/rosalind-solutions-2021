import org.apache.commons.lang3.tuple.Pair;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.IntStream;

public class SPLC {

    private static final String FASTA_RECORDS_FILENAME = "splc.txt";

    private static final String CODONS_TABLE_FILENAME = "codons_table.txt";

    private static final String STOP_CODON = "Stop";

    private static final int CODON_LENGTH = 3;

    // RNA Splicing
    public static void main(String[] args)
            throws IOException, URISyntaxException, SizeLimitExceededException {
        // Read FASTA format records from file
        List<Pair<String, String>> fastaRecords = Utils.getFastaRecords(FASTA_RECORDS_FILENAME);
        // Read codons pairs table file to properties
        Properties codonsPairs = Utils.getProperties(CODONS_TABLE_FILENAME);

        // Get DNA fasta record
        Pair<String, String> dnaPair = fastaRecords.get(0);

        // Collect introns from list of pairs
        String[] introns = fastaRecords.stream()
                .filter(pair -> !pair.getKey().equals(dnaPair.getKey()))
                .map(Pair::getValue)
                .toArray(String[]::new);

        // Form exons string by skipping introns in DNA
        StringBuilder exonsString = new StringBuilder();
        String dnaString = fastaRecords.get(0).getValue();

        int idx = 0;
        while (idx < dnaString.length()) {
            for (String intron : introns) {
                if (dnaString.startsWith(intron, idx)) {
                    idx += intron.length();
                    break;
                }
            }
            exonsString.append(dnaString.charAt(idx++));
        }

        // Form RNA and translate it to protein
        final String RNA = exonsString.toString().replace("T", "U");
        StringBuilder proteinStringBuilder = new StringBuilder();

        IntStream.iterate(0, i -> i < RNA.length(), i -> i + CODON_LENGTH)
                .mapToObj(i -> codonsPairs.get(RNA.substring(i, i + CODON_LENGTH)))
                .takeWhile(aminoAcid -> !aminoAcid.equals(STOP_CODON))
                .forEach(proteinStringBuilder::append);

        System.out.println(proteinStringBuilder);
    }
}
