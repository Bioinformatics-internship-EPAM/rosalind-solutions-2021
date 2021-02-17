import java.util.Comparator;
import java.util.List;

public class IdentifyingUnknownDNAQuickly {
    private static final String FileName = "rosalind_gc.txt";

    public static void main(String[] args) throws Exception {
        var entries = FileUtils.readFromFastaFile(FileName);

        var result = getResult(entries);

        System.out.println(result.getId());
        var roundedGcContent = (double)Math.round(result.getGcContent() * 100000000) / 1000000;
        System.out.println(roundedGcContent);
    }

    private static FastaEntry getResult(List<FastaEntry> entries) {
        return entries.stream().max(Comparator.comparing(FastaEntry::getGcContent)).get();
    }
}
