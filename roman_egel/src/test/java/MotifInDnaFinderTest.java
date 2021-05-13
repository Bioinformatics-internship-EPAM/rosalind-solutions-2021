import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MotifInDnaFinderTest {
  @Test
  public void find() {
    List<Integer> positions = MotifInDnaFinder.findPositions("GATATATGCATATACTT", "ATAT");
    System.out.println(positions.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(" ")));
    Assert.assertEquals(List.of(2, 4, 10), positions);
  }

}