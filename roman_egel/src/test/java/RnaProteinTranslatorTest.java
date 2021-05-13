import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RnaProteinTranslatorTest {

  @Test
  public void translate() {
    Assert.assertEquals("MAMAPRTEINSTRING", RnaProteinTranslator.translate("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"));
  }
}
