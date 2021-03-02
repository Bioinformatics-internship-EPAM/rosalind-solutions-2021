package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.fasta.FASTAItem;
import utils.fasta.FASTAReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsensusAndProfileCalculatorTest {

    @Test
    void testCalculateProfileMatrixOnNormalDataset() throws URISyntaxException, IOException {
        List<String> dataset = FASTAReader.readAllFromFile(
                Paths.get(ClassLoader.getSystemResource("CountPointMutationsSample.fasta").toURI()))
                .stream().map(FASTAItem::getSequence).collect(Collectors.toList());
        List<Map<Character, Integer>> profileMatrix = ConsensusAndProfileCalculator.calculateProfileMatrix(dataset);
        Assertions.assertEquals(List.of(5, 1, 0, 0, 5, 5, 0, 0),
                profileMatrix.stream().map(x -> x.get('A')).collect(Collectors.toList()));
        Assertions.assertEquals(List.of(0, 0, 1, 4, 2, 0, 6, 1),
                profileMatrix.stream().map(x -> x.get('C')).collect(Collectors.toList()));
        Assertions.assertEquals(List.of(1, 1, 6, 3, 0, 1, 0, 0),
                profileMatrix.stream().map(x -> x.get('G')).collect(Collectors.toList()));
        Assertions.assertEquals(List.of(1, 5, 0, 0, 0, 1, 1, 6),
                profileMatrix.stream().map(x -> x.get('T')).collect(Collectors.toList()));
    }

    @Test
    void testCalculateCalculateConsensusOnNormalDataset() {
        List<Map<Character, Integer>> profileMatrix = new ArrayList<>();
        profileMatrix.add(Map.of('A', 5, 'C', 0, 'G', 1, 'T', 1));
        profileMatrix.add(Map.of('A', 1, 'C', 0, 'G', 1, 'T', 5));
        profileMatrix.add(Map.of('A', 0, 'C', 1, 'G', 6, 'T', 0));
        profileMatrix.add(Map.of('A', 0, 'C', 4, 'G', 3, 'T', 0));
        profileMatrix.add(Map.of('A', 5, 'C', 2, 'G', 0, 'T', 0));
        profileMatrix.add(Map.of('A', 5, 'C', 0, 'G', 1, 'T', 1));
        profileMatrix.add(Map.of('A', 0, 'C', 6, 'G', 0, 'T', 1));
        profileMatrix.add(Map.of('A', 0, 'C', 1, 'G', 0, 'T', 6));
        String consensusString = ConsensusAndProfileCalculator.calculateConsensus(profileMatrix);
        Assertions.assertEquals("ATGCAACT", consensusString);
    }

}
