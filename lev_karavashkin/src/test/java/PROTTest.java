import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PROTTest {

    @Test
    void positiveTest(){
        Assertions.assertEquals("MAMAPRTEINSTRING",
            PROT.rnaToProtein("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"));
    }
}
