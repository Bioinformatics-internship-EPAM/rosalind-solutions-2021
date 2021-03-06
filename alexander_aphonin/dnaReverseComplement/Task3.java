import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static final Map<String, String> nucleotideComplements = Map.of(
            "A", "T",
            "C", "G",
            "T", "A",
            "G", "C"
            );
    public static String getDNAReverseComplement(final String dnaString) {
        // we can ultimately skip creation of just reversed string and make a stream out of reversed string here, but
        // it hurts readability and as we only have 1000bp at max doesn't cost much.
        final String reversedDnaString = new StringBuilder(dnaString).reverse().toString();
        return Stream.of(reversedDnaString.split(""))
                .map(nucleotideComplements::get)
                .collect(Collectors.joining());
    }
}
