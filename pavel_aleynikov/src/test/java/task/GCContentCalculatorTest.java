package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.fasta.FASTAItem;
import utils.fasta.FASTARead;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class GCContentCalculatorTest {

    @Test
    void testOnNormalDataset() throws URISyntaxException, IOException {
        Map.Entry<String, Double> result = FASTARead.readAllFromFile(
                Paths.get(ClassLoader.getSystemResource("ComputingGCContentSample.fasta").toURI()))
                .stream()
                .collect(Collectors.toMap(FASTAItem::getLabel, (item) -> GCContentCalculator.calculateGCContent(item.getSequence())))
                .entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .orElseThrow();
        Assertions.assertEquals("Rosalind_0808", result.getKey());
        Assertions.assertEquals(60.919540, result.getValue(), 0.001);
    }

}
