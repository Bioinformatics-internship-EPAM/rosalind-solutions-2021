import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class DatasetReader {
    public static String readFileIntoString(final Path path)
            throws IOException {
        return Files.readAllLines(path)
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
