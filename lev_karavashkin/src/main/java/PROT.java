import java.util.Map;

import static java.util.Map.entry;

public class PROT {

    private static Map<String, String> codonMap = Map.ofEntries(
        entry("UUU","F"),    entry("CUU","L"), entry("AUU", "I"), entry("GUU","V"),
        entry("UUC","F"),    entry("CUC","L"), entry("AUC", "I"), entry("GUC","V"),
        entry("UUA","L"),    entry("CUA","L"), entry("AUA", "I"), entry("GUA","V"),
        entry("UUG","L"),    entry("CUG","L"), entry("AUG", "M"), entry("GUG","V"),
        entry("UCU","S"),    entry("CCU","P"), entry("ACU", "T"), entry("GCU","A"),
        entry("UCC","S"),    entry("CCC","P"), entry("ACC", "T"), entry("GCC","A"),
        entry("UCA","S"),    entry("CCA","P"), entry("ACA", "T"), entry("GCA","A"),
        entry("UCG","S"),    entry("CCG","P"), entry("ACG", "T"), entry("GCG","A"),
        entry("UAU","Y"),    entry("CAU","H"), entry("AAU", "N"), entry("GAU","D"),
        entry("UAC","Y"),    entry("CAC","H"), entry("AAC", "N"), entry("GAC","D"),
        entry("UAA","Stop"), entry("CAA","Q"), entry("AAA", "K"), entry("GAA","E"),
        entry("UAG","Stop"), entry("CAG","Q"), entry("AAG", "K"), entry("GAG","E"),
        entry("UGU","C"),    entry("CGU","R"), entry("AGU", "S"), entry("GGU","G"),
        entry("UGC","C"),    entry("CGC","R"), entry("AGC", "S"), entry("GGC","G"),
        entry("UGA","Stop"), entry("CGA","R"), entry("AGA", "R"), entry("GGA","G"),
        entry("UGG","W"),    entry("CGG","R"), entry("AGG", "R"), entry("GGG","G")
    );

    public static String rnaToProtein(String rna) {
        StringBuilder proteinStr = new StringBuilder();

        for (int i = 0; i < rna.length(); i+= 3) {
            String subRna = rna.substring(i,i+3);

            String code = codonMap.get(subRna);
            if(code.equals("Stop")) return proteinStr.toString();

            proteinStr.append(code);
        }
        return proteinStr.toString();
    }
}
