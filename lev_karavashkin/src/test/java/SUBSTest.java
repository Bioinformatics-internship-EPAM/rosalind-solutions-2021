import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SUBSTest {

    @Test
    void positiveTest() {
        Assertions.assertEquals(Arrays.asList(2, 4, 10),
            SUBS.getLocations("GATATATGCATATACTT", "ATAT"));

        Assertions.assertEquals(Arrays.asList(2, 5, 6, 15, 17, 18),
            SUBS.getLocations("AUGCUUCAGAAAGGUCUUACG", "U"));
    }
}
