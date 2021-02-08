import java.nio.file.Paths;

public class TranscribingDNAIntoRNA {
    public static void main(String[] args) throws Exception {
        final String datasetStr = DatasetReader.readFileIntoString(Paths.get("/tmp/rosalind_rna.txt"));
        final String rna = transcribeDNAToRNA(datasetStr);
        System.out.printf("%s", rna);
    }

    public static String transcribeDNAToRNA(final String dna) {
        return dna.replace('T', 'U');
    }
}
