package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CountDNANucleotidesCalculatorTest {

    @Test
    void testOnNormalDataset() {
        final String dna = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        Map<Character, Long> result = CountDNANucleotidesCalculator.calculate(dna);
        Assertions.assertEquals(Map.of('A', 20L, 'C', 12L, 'G', 17L, 'T', 21L), result);
    }

    @Test
    void testOnEmptyDataset() {
        final String dna = "";
        Map<Character, Long> result = CountDNANucleotidesCalculator.calculate(dna);
        Assertions.assertEquals(Map.of('A', 0L, 'C', 0L, 'G', 0L, 'T', 0L), result);
    }

}
