import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PointMutationCounter {
  public static long calculateHammingDistance(char[] s, char[] t) {
    return IntStream.range(0, s.length)
        .filter(i -> s[i] != t[i])
        .count();
  }
}
