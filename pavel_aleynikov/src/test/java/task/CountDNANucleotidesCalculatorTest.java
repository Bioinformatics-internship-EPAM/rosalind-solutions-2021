package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CountDNANucleotidesCalculatorTest {

    @Test
    void testOnNormalDataset() {
        final String dna = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        Map<Character, Integer> result = CountDNANucleotidesCalculator.calculate(dna);
        Assertions.assertEquals(Map.of('A', 20, 'C', 12, 'G', 17, 'T', 21), result);
    }

    @Test
    void testOnEmptyDataset() {
        final String dna = "";
        Map<Character, Integer> result = CountDNANucleotidesCalculator.calculate(dna);
        Assertions.assertEquals(Map.of('A', 0, 'C', 0, 'G', 0, 'T', 0), result);
    }

}
