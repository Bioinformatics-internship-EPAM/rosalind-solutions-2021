package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplementingDNAGeneratorTest {

    @Test
    void testOnNormalDataset() {
        Assertions.assertEquals("ACCGGGTTTT", ComplementingDNAGenerator.generate("AAAACCCGGT"));
    }

}
