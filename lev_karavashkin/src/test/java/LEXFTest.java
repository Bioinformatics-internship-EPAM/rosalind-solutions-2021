import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LEXFTest {

    @Test
    void positiveTest(){

        Assertions.assertEquals(
            new ArrayList<>(Arrays.asList(
                "AA",
                "AC",
                "AG",
                "AT",
                "CA",
                "CC",
                "CG",
                "CT",
                "GA",
                "GC",
                "GG",
                "GT",
                "TA",
                "TC",
                "TG",
                "TT"
            )),
            LEXF.getOrdered(new char[]{'A','C','G','T'},2));
    }
}
