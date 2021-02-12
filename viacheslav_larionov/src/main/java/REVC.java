import org.apache.commons.lang3.StringUtils;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class REVC {

    private static final String TASK_FILENAME = "revc.txt";

    // Complementing a Strand of DNA
    public static void main(String[] args) throws IOException, URISyntaxException, SizeLimitExceededException {
        List<String> lines = Utils.readLinesFromFile(TASK_FILENAME);

        if (lines.size() == 1) {
            String dnaReversed = new StringBuilder(lines.get(0)).reverse().toString();
            String dnaComplement = StringUtils.replaceChars(dnaReversed, "ACGT", "TGCA");
            System.out.println(dnaComplement);
        } else {
            throw new SizeLimitExceededException("Must be one DNA sequence in file");
        }
    }
}
