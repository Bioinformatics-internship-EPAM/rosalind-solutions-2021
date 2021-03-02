package my.rosalind;

import java.util.HashMap;
import java.util.Map;

public class TranslatingRNAIntoProtein {
    public String exec(String rna) {
        var map = getRNACodonTable();
        var proteinBuilder = new StringBuilder();

        for (int i = 0; i < rna.length(); i += 3) {
            var token = rna.substring(i, i+3);

            var symbol = map.get(token);
            if (symbol == null) {
                break;
            }

            proteinBuilder.append(symbol);
        }

        return proteinBuilder.toString();
    }

    private Map<String, Character> getRNACodonTable() {
        var table = "UUU F      CUU L      AUU I      GUU V\n" +
                "UUC F      CUC L      AUC I      GUC V\n" +
                "UUA L      CUA L      AUA I      GUA V\n" +
                "UUG L      CUG L      AUG M      GUG V\n" +
                "UCU S      CCU P      ACU T      GCU A\n" +
                "UCC S      CCC P      ACC T      GCC A\n" +
                "UCA S      CCA P      ACA T      GCA A\n" +
                "UCG S      CCG P      ACG T      GCG A\n" +
                "UAU Y      CAU H      AAU N      GAU D\n" +
                "UAC Y      CAC H      AAC N      GAC D\n" +
                "UAA Stop   CAA Q      AAA K      GAA E\n" +
                "UAG Stop   CAG Q      AAG K      GAG E\n" +
                "UGU C      CGU R      AGU S      GGU G\n" +
                "UGC C      CGC R      AGC S      GGC G\n" +
                "UGA Stop   CGA R      AGA R      GGA G\n" +
                "UGG W      CGG R      AGG R      GGG G ";

        table = table.replace("\n", " ");

        var result = new HashMap<String, Character>();
        var tokens = table.split(" ");
        var counter = 0;

        String key = null;
        for (var token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (counter % 2 == 0) {
                key = token;
            } else {
                var value = token;
                if (value.equals("Stop")) {
                    value = null;
                }

                result.put(key, value != null ? value.charAt(0) : null);
                key = null;
            }

            counter++;
        }

        return result;
    }
}
