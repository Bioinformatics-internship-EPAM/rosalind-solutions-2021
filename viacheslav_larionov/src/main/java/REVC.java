import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class REVC {

    private static final String filename = "revc.txt";

    // Complementing a Strand of DNA
    public static void main(String[] args) {
        List<String> lines = Utils.readDNAStringsFromFile(filename);

        if (lines.size() == 1) {
            String dnaReversed = new StringBuilder(lines.get(0)).reverse().toString();
            String dnaComplement = StringUtils.replaceChars(dnaReversed, "ACGT", "TGCA");
            System.out.println(dnaComplement);
        }
    }
}
