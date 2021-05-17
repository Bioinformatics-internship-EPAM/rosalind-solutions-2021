package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RNAIntoProteinTranslatorTest {

    @Test
    void testOnNormalDataset() {
        Assertions.assertEquals("MAMAPRTEINSTRING", RNAIntoProteinTranslator.translate("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"));
    }

}
