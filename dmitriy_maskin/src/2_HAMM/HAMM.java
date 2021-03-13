package HAMM;

import utils.Utils;

public class HAMM {
    private static final String FILE_NAME = "hamm_input.txt";
    private static final String FILE_PATH = "src/HAMM/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        String str1 = Utils.readFromFile(FILE_PATH).get(0);
        String str2 = Utils.readFromFile(FILE_PATH).get(1);

        System.out.println(HAMM.hammingDistance(str1, str2));
    }

    public static int hammingDistance(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        return diff;
    }
}
