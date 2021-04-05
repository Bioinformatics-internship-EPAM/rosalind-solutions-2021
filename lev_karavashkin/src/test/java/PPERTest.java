import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PPERTest {

    @Test
    void positiveTest(){
        Assertions.assertEquals("51200",
            PPER.getPartPermutations(21, 7));
    }
}
