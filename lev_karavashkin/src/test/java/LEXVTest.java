import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LEXVTest {

    @Test
    void positiveTest(){

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(
                "D",
                "DD",
                "DDD",
                "DDN",
                "DDA",
                "DN",
                "DND",
                "DNN",
                "DNA",
                "DA",
                "DAD",
                "DAN",
                "DAA",
                "N",
                "ND",
                "NDD",
                "NDN",
                "NDA",
                "NN",
                "NND",
                "NNN",
                "NNA",
                "NA",
                "NAD",
                "NAN",
                "NAA",
                "A",
                "AD",
                "ADD",
                "ADN",
                "ADA",
                "AN",
                "AND",
                "ANN",
                "ANA",
                "AA",
                "AAD",
                "AAN",
                "AAA"
                )),
            LEXV.getOrdered(new char[]{'D','N','A'},3));
    }
}
