package tasks;

//Link: http://rosalind.info/problems/revc/
public class ComplementingStrandOfDna {
    public static String compute(String dna) {
        StringBuilder sb = new StringBuilder();
        for (int i = dna.length() - 1; i >= 0; i--) {
            sb.append(getComplement(dna.charAt(i)));
        }
        return sb.toString();
    }

    private static char getComplement(char symbol) {
        switch (symbol) {
            case 'A':
                return 'T';
            case 'T':
                return 'A';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            default:
                return symbol;
        }

    }
}
