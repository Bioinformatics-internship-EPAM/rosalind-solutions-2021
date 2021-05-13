import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RnaProteinTranslator {
  private static final String startCodon = "AUG";
  private static final String strTable = """
      UUU F      CUU L      AUU I      GUU V
      UUC F      CUC L      AUC I      GUC V
      UUA L      CUA L      AUA I      GUA V
      UUG L      CUG L      AUG M      GUG V
      UCU S      CCU P      ACU T      GCU A
      UCC S      CCC P      ACC T      GCC A
      UCA S      CCA P      ACA T      GCA A
      UCG S      CCG P      ACG T      GCG A
      UAU Y      CAU H      AAU N      GAU D
      UAC Y      CAC H      AAC N      GAC D
      UAA Stop   CAA Q      AAA K      GAA E
      UAG Stop   CAG Q      AAG K      GAG E
      UGU C      CGU R      AGU S      GGU G
      UGC C      CGC R      AGC S      GGC G
      UGA Stop   CGA R      AGA R      GGA G
      UGG W      CGG R      AGG R      GGG G
      """;
  private static final Map<String, String> rnaCodonTable = strTable.lines()
      .flatMap(s -> Arrays.stream(s.split(" {3,6}")))
      .map(String::trim)
      .map(s -> s.split(" "))
      .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));

  public static String translate(String rna) {
    StringBuilder sb = new StringBuilder();
    int start = rna.indexOf(startCodon);

    if (start == -1) {
      throw new IllegalArgumentException();
    }

    sb.append(rnaCodonTable.get(startCodon));
    for (int i = start + 3; i < rna.length(); i += 3) {
      String codon = rnaCodonTable.get(rna.substring(i, i + 3));
      if (codon == null) {
        throw new IllegalArgumentException();
      } else if ("Stop".equals(codon)) {
        break;
      } else {
        sb.append(codon);
      }
    }

    return sb.toString();
  }
}
