import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DatasetReader {
    public static String readFileIntoString(final InputStream inputStream)
            throws IOException {
        final StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append((line));
            }
        }
        return resultStringBuilder.toString();
    }
}
