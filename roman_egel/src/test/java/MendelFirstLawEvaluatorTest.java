import org.junit.Assert;
import org.junit.Test;


public class MendelFirstLawEvaluatorTest {
  @Test
  public void test() {
    Assert.assertEquals(0.642668, MendelFirstLawEvaluator.calculateProbability(17, 18, 30), 0.0001);
  }

}