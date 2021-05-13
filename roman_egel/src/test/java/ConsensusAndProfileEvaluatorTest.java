import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsensusAndProfileEvaluatorTest {
  private static final String fastaDna = """
      >Rosalind_1
        ATCCAGCT
        >Rosalind_2
        GGGCAACT
        >Rosalind_3
        ATGGATCT
        >Rosalind_4
        AAGCAACC
        >Rosalind_5
        TTGGAACT
        >Rosalind_6
        ATGCCATT
        >Rosalind_7
        ATGGCACT""";

  @Test
  public void getProfile() {
    Map.Entry<String, Map<String, Map<Integer, Long>>> consensusToProfile = ConsensusAndProfileEvaluator.evaluate(fastaDna);
    System.out.println(consensusToProfile.getKey());
    String profile = consensusToProfile.getValue().entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .map(e -> e.getKey() + ": " + e.getValue().entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).map(e2 -> String.valueOf(e2.getValue())).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
    System.out.println(profile);
    Assert.assertEquals("ATGCAACT", consensusToProfile.getKey());
    Assert.assertEquals("""
        A: 5 1 0 0 5 5 0 0
        C: 0 0 1 4 2 0 6 1
        G: 1 1 6 3 0 1 0 0
        T: 1 5 0 0 0 1 1 6
        """.trim(), profile);

  }



}