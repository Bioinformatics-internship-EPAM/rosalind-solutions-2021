package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.fasta.FASTAItem;
import utils.fasta.FASTAReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

public class OverlapGraphBuilderTest {

    @Test
    void testOnNormalDataset() throws URISyntaxException, IOException {
        List<FASTAItem> dataset = FASTAReader.readAllFromFile(
                Paths.get(ClassLoader.getSystemResource("OverlapGraphBuilderSample.fasta").toURI()));
        List<List<String>> result = OverlapGraphBuilder.build(dataset, 3);
        Assertions.assertEquals(List.of(
                List.of("Rosalind_0498", "Rosalind_2391"),
                List.of("Rosalind_0498", "Rosalind_0442"),
                List.of("Rosalind_2391", "Rosalind_2323")), result);
    }

}
