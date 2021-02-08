import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.IntStream;

public class SPLC {

    // RNA Splicing
    public static void main(String[] args) {
        // Read FASTA format records from file
        LinkedHashMap<String, String> fastaRecordsMap = Utils.getFastaRecords("splc.txt");
        // Read codons pairs table file to properties
        Properties codonsPairs = Utils.getProperties("codons_table.txt");

        // Get map key to DNA fasta record
        String dnaKey = fastaRecordsMap.keySet().iterator().next();
        final String DNA = fastaRecordsMap.get(dnaKey);

        // Delete introns from DNA
        String[] introns = fastaRecordsMap.keySet().stream()
                .filter(key -> !key.equals(dnaKey))
                .map(fastaRecordsMap::get)
                .toArray(String[]::new);
        String[] replacements = IntStream.rangeClosed(0, introns.length - 1)
                .mapToObj(i -> "")
                .toArray(String[]::new);
        String exonsString = StringUtils
                .replaceEach(DNA, introns, replacements);

        // Form RNA and translate it to protein
        final String RNA = exonsString.replace("T", "U");
        StringBuilder proteinStringBuilder = new StringBuilder();

        IntStream.iterate(0, i -> i < RNA.length(), i -> i + 3)
                .mapToObj(i -> codonsPairs.get(RNA.substring(i, i + 3)))
                .filter(aminoAcid -> !aminoAcid.equals("Stop"))
                .forEach(proteinStringBuilder::append);

        System.out.println(proteinStringBuilder);
    }
}
