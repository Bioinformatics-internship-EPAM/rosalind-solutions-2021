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
        int[] res = new int[] {0, 0, 0, 0};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                res[0]++;
            if (s.charAt(i) == 'C')
                res[1]++;
            if (s.charAt(i) == 'G')
                res[2]++;
            if (s.charAt(i) == 'T')
                res[3]++;
        }
        return res;
    }
}
