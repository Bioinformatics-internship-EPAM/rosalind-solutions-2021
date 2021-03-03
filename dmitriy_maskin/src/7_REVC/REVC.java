package REVC;

import utils.Utils;

public class REVC {
    private static final String FILE_NAME = "revc_input.txt";
    private static final String FILE_PATH = "src/REVC/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        String s3 = Utils.readFromFile(FILE_PATH).get(0);

        System.out.println(REVC.complete(s3));
    }

    public static String complete(String s) {
        StringBuilder sReverse = new StringBuilder(s).reverse();
        String res = "";
        for (int i = 0; i < sReverse.length(); i++) {
            if (sReverse.charAt(i) == 'A') {
                res += 'T';
                continue;
            }
            if (sReverse.charAt(i) == 'C') {
                res += 'G';
                continue;
            }
            if (sReverse.charAt(i) == 'T') {
                res += 'A';
                continue;
            }
            if (sReverse.charAt(i) == 'G') {
                res += 'C';
                continue;
            }
        }
        return res;
    }
}
