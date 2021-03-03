package RNA;

import utils.Utils;

public class RNA {
    private static final String FILE_NAME = "rna_input.txt";
    private static final String FILE_PATH = "src/RNA/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        String s2 = Utils.readFromFile(FILE_PATH).get(0);

        System.out.println(RNA.transcrib(s2));
    }

    public static String transcrib(String s) {
        return s.replace('T', 'U');
    }
}
