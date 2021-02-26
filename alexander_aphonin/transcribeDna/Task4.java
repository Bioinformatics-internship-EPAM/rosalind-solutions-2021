import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static String getTranscribedRna(final String dnaString) {
        return dnaString.replace('T','U');
    }
}
