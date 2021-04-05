import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RNATest {

    @Test
    void positiveTest() {
        Assertions.assertEquals("GAUGGAACUUGACUACGUAAAUU",
            RNA.toRNA("GATGGAACTTGACTACGTAAATT"));
    }
}
