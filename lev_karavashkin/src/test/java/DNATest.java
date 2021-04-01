import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DNATest {

    @Test
    void positiveTest(){
        // Count A C G T in string
        Assertions.assertEquals("20 12 17 21",
            DNA.count("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"));

        Assertions.assertEquals("1 0 0 0",
            DNA.count("A"));

        Assertions.assertEquals("0 1 0 0",
            DNA.count("C"));

        Assertions.assertEquals("0 0 1 0",
            DNA.count("G"));

        Assertions.assertEquals("0 0 0 1",
            DNA.count("T"));
    }
}
