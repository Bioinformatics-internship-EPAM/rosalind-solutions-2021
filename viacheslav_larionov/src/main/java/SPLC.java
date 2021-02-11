import org.apache.commons.lang3.StringUtils;
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

        // Delete introns from DNA
        String exonsString = dnaPair.getValue();
        for (int i = 0; i < exonsString.length(); ++i) {
            for (String intron : introns) {
                if (intron.length() <= exonsString.length() - i
                        && exonsString.startsWith(intron, i)) {
                    exonsString = StringUtils.replaceOnce(exonsString, intron, "");
                    break;
                }
            }
        }

        // Form RNA and translate it to protein
        final String RNA = exonsString.replace("T", "U");
        StringBuilder proteinStringBuilder = new StringBuilder();

        IntStream.iterate(0, i -> i < RNA.length(), i -> i + 3)
                .mapToObj(i -> codonsPairs.get(RNA.substring(i, i + 3)))
                .takeWhile(aminoAcid -> !aminoAcid.equals("Stop"))
                .forEach(proteinStringBuilder::append);

        System.out.println(proteinStringBuilder);
    }
}
