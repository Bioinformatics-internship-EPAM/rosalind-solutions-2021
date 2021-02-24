import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static String getTranscribedRna(final String dnaString) {
        return Stream.of(dnaString.split(""))
                .map(nucl -> {
                    if (nucl.equals("T")) {
                        return "U";
                    }
                    return nucl;
                })
                .collect(Collectors.joining());
    }
}
