import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointMutationCounterTest {

  @Test
  public void testHammingDistanceCalculator() {
    String s = "GAGCCTACTAACGGGAT";
    String t = "CATCGTAATGACGGCCT";
    Assert.assertEquals(7, PointMutationCounter.calculateHammingDistance(s.toCharArray(), t.toCharArray()));
  }

}
