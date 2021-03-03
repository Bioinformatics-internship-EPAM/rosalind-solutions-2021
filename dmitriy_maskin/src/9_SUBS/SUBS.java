package SUBS;

import utils.Utils;

public class SUBS {
    private static final String FILE_NAME = "subs_input.txt";
    private static final String FILE_PATH = "src/SUBS/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        String s = Utils.readFromFile(FILE_PATH).get(0);
        String substr = Utils.readFromFile(FILE_PATH).get(1);

        System.out.println(SUBS.locations(s, substr));
    }

    public static String locations(String s, String substr) {
        String result = "";
        int lastIndex = 0;
        while(lastIndex != -1) {

            lastIndex = s.indexOf(substr,lastIndex);

            if(lastIndex != -1) {
                result += ++lastIndex + " ";
                lastIndex += 1;
            }
        }
        return result;
    }
}
