package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountPointMutationsCalculatorTest {

    @Test
    void testOnNormalDataset() {
        Assertions.assertEquals(7,
                CountPointMutationsCalculator.calculate("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT"));
    }

}
