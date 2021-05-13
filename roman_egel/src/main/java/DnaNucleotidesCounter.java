import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class DnaNucleotidesCounter {
    public static Map<String, Long> count(String dna) {
        return dna.chars()
            .mapToObj(i -> String.valueOf((char) i))
            .collect(groupingBy(identity(), counting()));
    }
}
