import java.util.HashMap;

public class TranslatingRNAintoProtein {
    private static final String FileName = "rosalind_prot.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName).get(0);

        var result = getResult(input);

        System.out.println(result);
    }

    private static String getResult(String input) {
        var table = getTable();

        var sb = new StringBuilder();
        for (int i = 0; i < input.length() - 3; i = i + 3) {
            var codon = input.substring(i, i + 3);
            var amino = table.get(codon);
            sb.append(amino);
        }

        return sb.toString();
    }

    private static HashMap<String, Character> getTable() {
        var table = new HashMap<String, Character>();
        table.put("UUU", 'F');
        table.put("UUC", 'F');
        table.put("UUA", 'L');
        table.put("UUG", 'L');
        table.put("CUU", 'L');
        table.put("CUC", 'L');
        table.put("CUA", 'L');
        table.put("CUG", 'L');
        table.put("UCU", 'S');
        table.put("UCC", 'S');
        table.put("UCA", 'S');
        table.put("UCG", 'S');
        table.put("UAU", 'Y');
        table.put("UAC", 'Y');
        table.put("AUU", 'I');
        table.put("AUC", 'I');
        table.put("AUA", 'I');
        table.put("GUU", 'V');
        table.put("GUC", 'V');
        table.put("GUA", 'V');
        table.put("GUG", 'V');
        table.put("AUG", 'M');
        table.put("CCU", 'P');
        table.put("CCC", 'P');
        table.put("CCA", 'P');
        table.put("CCG", 'P');
        table.put("ACU", 'T');
        table.put("ACC", 'T');
        table.put("ACA", 'T');
        table.put("ACG", 'T');
        table.put("GCU", 'A');
        table.put("GCC", 'A');
        table.put("GCA", 'A');
        table.put("GCG", 'A');
        table.put("CAU", 'H');
        table.put("CAC", 'H');
        table.put("AAU", 'N');
        table.put("AAC", 'N');
        table.put("GAU", 'D');
        table.put("GAC", 'D');
        table.put("CAA", 'Q');
        table.put("CAG", 'Q');
        table.put("AAA", 'K');
        table.put("AAG", 'K');
        table.put("GAA", 'E');
        table.put("GAG", 'E');
        table.put("UGU", 'C');
        table.put("UGC", 'C');
        table.put("CGU", 'R');
        table.put("CGC", 'R');
        table.put("CGA", 'R');
        table.put("AGA", 'R');
        table.put("CGG", 'R');
        table.put("AGG", 'R');
        table.put("AGU", 'S');
        table.put("AGC", 'S');
        table.put("GGU", 'G');
        table.put("GGC", 'G');
        table.put("GGA", 'G');
        table.put("GGG", 'G');
        table.put("UGG", 'W');
        table.put("UAA", '1');
        table.put("UAG", '1');
        table.put("UGA", '1');

        return table;
    }
}

