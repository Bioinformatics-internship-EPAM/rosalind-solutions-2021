package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MotifInDNAFinderTest {

    @Test
    void testOnNormalDataset() {
        List<Integer> result = MotifInDNAFinder.findAll("GATATATGCATATACTT", "ATAT");
        Assertions.assertEquals(List.of(2, 4, 10), result);
    }

}
