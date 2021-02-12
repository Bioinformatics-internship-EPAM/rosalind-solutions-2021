import org.apache.commons.lang3.tuple.Pair;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.IntStream;

public class SPLC {

    private static final String fastaRecordsFilename = "splc.txt";

    private static final String codonsTableFilename = "codons_table.txt";

    // RNA Splicing
    public static void main(String[] args)
            throws IOException, URISyntaxException, SizeLimitExceededException {
        // Read FASTA format records from file
        List<Pair<String, String>> fastaRecords = Utils.getFastaRecords(fastaRecordsFilename);
        // Read codons pairs table file to properties
        Properties codonsPairs = Utils.getProperties(codonsTableFilename);

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

        IntStream.iterate(0, i -> i < RNA.length(), i -> i + 3)
                .mapToObj(i -> codonsPairs.get(RNA.substring(i, i + 3)))
                .takeWhile(aminoAcid -> !aminoAcid.equals("Stop"))
                .forEach(proteinStringBuilder::append);

        System.out.println(proteinStringBuilder);
    }
}
