import org.junit.Assert;
import org.junit.Test;

public class RabbitPairsEvaluatorTest {
    @Test
    public void testSimple() {
        Assert.assertEquals(19, RabbitPairsEvaluator.evaluate(5, 3));
    }

}
