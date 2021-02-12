import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HAMM {

    private static final String TASK_FILENAME = "hamm.txt";

    // Counting Point Mutations
    public static void main(String[] args) throws IOException, SizeLimitExceededException, URISyntaxException {
        List<String> dnaStrings = Utils.readLinesFromFile(TASK_FILENAME);

        if (dnaStrings.size() == 2) {
            if (dnaStrings.get(0).length() == dnaStrings.get(1).length()) {
                System.out.println(Utils.hammingDistance(dnaStrings.get(0), dnaStrings.get(1)));
            } else {
                throw new IllegalArgumentException("DNAs lengths must be equal");
            }
        } else {
            throw new SizeLimitExceededException("Must be 2 DNA sequences in file");
        }
    }
}
