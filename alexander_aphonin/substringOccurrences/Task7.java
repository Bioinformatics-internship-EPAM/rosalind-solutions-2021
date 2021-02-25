import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    public static int[] findAllSubstringOccurrences(final String dnaString, final String substring) {
        // probably the coolest thing learnt via rosalind. "ATAT" pattern doesn't account for overlapping
        // occurrences. (?=ATAT) does.
        Pattern substringPattern = Pattern.compile("(?=" + substring + ")");
        Matcher substringMatcher = substringPattern.matcher(dnaString);
        // for some reason the next piece doesn't work. Would appreciate the comment.
        // .map(occurrence -> occurrence.start() + 1)
        // .collect(Collectors.toList());
        return substringMatcher.results()
                .mapToInt(occurrence -> occurrence.start() + 1)
                .toArray();
    }
}
