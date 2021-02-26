import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    private static String readInputFileIntoString(final String inputFileName) {
        final StringBuilder resultStringBuilder = new StringBuilder();
        // with throws in method's signature looks better, but there is no proper handling anyway
        List<String> fileLines = new ArrayList<>();
        try {
            fileLines = Files.readAllLines(Path.of(inputFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join("", fileLines);

    }

    public static void countDNANucleotides(final String inputFileName) {
            final String nucleotidesString = readInputFileIntoString(inputFileName); // A C G T
            // there are other more efficient ways of making an array from a string, but for shown datasets it'll do
            final Map<String, Long> l = Stream.of(nucleotidesString.split(""))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(l.toString());

    }
}
