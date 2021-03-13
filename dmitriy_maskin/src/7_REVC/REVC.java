package REVC;

import utils.Utils;

public class REVC {
    private static final String FILE_NAME = "revc_input.txt";
    private static final String FILE_PATH = "src/REVC/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        String s3 = Utils.readFromFile(FILE_PATH).get(0);

        System.out.println(REVC.complete(s3));
    }

    public static StringBuilder complete(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i-- ) {
            if (s.charAt(i) == 'A') {
                result.append('T');
                continue;
            }
            else if (s.charAt(i) == 'C') {
                result.append('G');
                continue;
            }
            else if (s.charAt(i) == 'T') {
                result.append('A');
                continue;
            }
            else if (s.charAt(i) == 'G') {
                result.append('C');
                continue;
            }
        }

        return result;
    }
}
