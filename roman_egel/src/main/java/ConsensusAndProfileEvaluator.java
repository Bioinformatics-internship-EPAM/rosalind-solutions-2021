import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsensusAndProfileEvaluator {
  public static Map.Entry<String, Map<String, Map<Integer, Long>>> evaluate(String fastaDnas) {
    List<String> dnas = Arrays.stream(fastaDnas.split(">\\w+\n"))
        .filter(Predicate.not(String::isBlank))
        .map(dna -> dna.replace("\n", "").trim())
        .collect(Collectors.toList());
    Map<String, Map<Integer, Long>> profile = dnas.stream()
        .flatMap(dna -> IntStream.range(0, dna.length()).mapToObj(i -> Map.entry(String.valueOf(dna.charAt(i)), i)))
        .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.groupingBy(Map.Entry::getValue, Collectors.counting())));

    int n = dnas.stream()
        .map(String::length)
        .max(Integer::compareTo)
        .orElse(0);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int index = i;

      String key = profile.entrySet().stream()
          .peek(e -> e.getValue().putIfAbsent(index, 0L))
          .map(e -> Map.entry(e.getKey(), e.getValue().get(index)))
          .max(Map.Entry.comparingByValue())
          .map(Map.Entry::getKey)
          .orElseThrow();

      sb.append(key);
    }

    return Map.entry(sb.toString(), profile);
  }
}
