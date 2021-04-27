package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RabbitPopulationCalculatorTest {

    @Test
    void testOnNormalDataset() {
        Assertions.assertEquals(19, RabbitPopulationCalculator.calculate(5, 3));
    }

    @Test
    void testOnZeroMonth() {
        Assertions.assertEquals(1, RabbitPopulationCalculator.calculate(0, 3));
    }

    @Test
    void testOnZeroLitter() {
        Assertions.assertEquals(1, RabbitPopulationCalculator.calculate(5, 0));
    }

    @Test
    void testOnMaxMonthAndLitter() {
        Assertions.assertEquals(148277527396903091L, RabbitPopulationCalculator.calculate(40, 5));
    }

}
