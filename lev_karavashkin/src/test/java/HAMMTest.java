import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HAMMTest {

    @Test
    void positiveTest(){
        Assertions.assertEquals(7,
            HAMM.countPointMutations("GAGCCTACTAACGGGAT","CATCGTAATGACGGCCT"));

        Assertions.assertEquals(4,
            HAMM.countPointMutations("AAAA","BBBB"));

        Assertions.assertEquals(0,
            HAMM.countPointMutations("AAAA","AAAA"));
    }
}
