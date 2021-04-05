import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PRTMTest {

    @Test
    void positiveTest(){
        Assertions.assertEquals(821.392,
            PRTM.calcProteinMass("SKADYEK"));
    }
}
