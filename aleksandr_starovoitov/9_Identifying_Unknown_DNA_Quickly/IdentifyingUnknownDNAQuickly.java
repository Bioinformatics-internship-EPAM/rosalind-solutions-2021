import java.util.Comparator;
import java.util.List;

public class IdentifyingUnknownDNAQuickly {
    private static final String FileName = "rosalind_gc.txt";

    public static void main(String[] args) throws Exception {
        var entries = FileUtils.readFromFastaFile(FileName);

        var result = getResult(entries);

        System.out.println(result.getId());
        System.out.println(result.getGcContent());
    }

    private static FastaEntry getResult(List<FastaEntry> entries) {
        return entries.stream().max(Comparator.comparing(FastaEntry::getGcContent)).get();
    }
}
