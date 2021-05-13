import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Predicate;

public class GCContentEvaluator {
  private static final String LINE_SEPARATOR = System.lineSeparator();

  public static Map.Entry<String, Double> getHighestGCContentFromFasta(String fastaText) {
    return Arrays.stream(fastaText.split(">"))
        .filter(Predicate.not(String::isBlank))
        .map(GCContentEvaluator::computeGcContent)
        .max(Comparator.comparingDouble(Map.Entry::getValue))
        .orElseThrow();
  }


  private static Map.Entry<String, Double> computeGcContent(String dna) {
    int i = dna.indexOf(LINE_SEPARATOR);

    int numOfGCSymbols = 0;
    char[] symbols = dna.substring(i + 1).replace(LINE_SEPARATOR, "").trim().toCharArray();
    for (char symbol : symbols) {
      if (symbol == 'G' || symbol == 'C') {
        numOfGCSymbols++;
      }
    }

    return Map.entry(dna.substring(0, i), (((double) numOfGCSymbols) / symbols.length) * 100);
  }
}
