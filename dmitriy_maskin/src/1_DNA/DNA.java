package DNA;

import utils.Utils;

public class DNA {
    private static final String FILE_NAME = "dna_input.txt";
    private static final String FILE_PATH = "src/DNA/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        String input = Utils.readFromFile(FILE_PATH).get(0);

        int[] result = countNucleotides(input);

        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
        System.out.println("\n");
    }

    public static int[] countNucleotides(String s) {
        char[] nucleotides = new char[] {'A', 'C', 'G', 'T'};
        int[] counts = new int[nucleotides.length];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < nucleotides.length; j++) {
                if (s.charAt(i) == nucleotides[j]) {
                    counts[j]++;
                }
            }
        }
        return counts;
    }
}
