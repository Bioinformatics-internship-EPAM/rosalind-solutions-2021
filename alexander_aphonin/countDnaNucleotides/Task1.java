import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    private String readInputStreamIntoString(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append((line));
            }
        }
        return resultStringBuilder.toString();
    }

    public void countDNANucleotides(String inputFileName) {
        InputStream inputFileStream = null;
        try {
            inputFileStream = new FileInputStream(inputFileName);
            String nucleotidesString = readInputStreamIntoString(inputFileStream); // A C G T
            // there are other more efficient ways of making an array from a string, but for shown datasets it'll do
            Map<String, Long> l = Stream.of(nucleotidesString.split(""))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(l.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO: some thoughtful handling
            e.printStackTrace();
        }
    }
}
