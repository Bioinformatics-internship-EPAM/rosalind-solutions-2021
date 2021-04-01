import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FIBTest {

    @Test
    void positiveTest() {
        Assertions.assertEquals(19,
            FIB.getTotalRabbitPairs(5, 3));

        Assertions.assertEquals(1,
            FIB.getTotalRabbitPairs(5, 1));

        Assertions.assertEquals(1,
            FIB.getTotalRabbitPairs(5, 2));
    }
}
