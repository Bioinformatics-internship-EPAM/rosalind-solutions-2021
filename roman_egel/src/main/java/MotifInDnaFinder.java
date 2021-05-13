import java.util.ArrayList;
import java.util.List;

public class MotifInDnaFinder {
  public static List<Integer> findPositions(String dna, String partOfDnaToFind) {
    List<Integer> positions = new ArrayList<>();
    for (int i = dna.indexOf(partOfDnaToFind); i >= 0; i = dna.indexOf(partOfDnaToFind, i + 1)) {
      positions.add(i + 1);
    }

    return positions;
  }
}
