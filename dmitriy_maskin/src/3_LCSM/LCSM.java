package LCSM;

import utils.Utils;

import java.util.List;

public class LCSM {
    private static final String FILE_NAME = "lcsm_input.txt";
    private static final String FILE_PATH = "src/LCSM/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        List<String> strs = Utils.readFromFile(FILE_PATH);

        System.out.println("(If multiple solutions exist, you may return any single solution.)");

        System.out.println(LCSM.identifyCommonSubstr(strs));
    }

    static String smallestStr(List<String> strArr) {
        String result = "";
        for (String s : strArr) {
            if (result.length() < s.length()) {
                result = s;
            }
        }
        return result;
    }

    static boolean occurs(String tempCom, List<String> strArr) {
        for (String string : strArr) {
            if (!string.contains(tempCom)) {
                return false;
            }
        }
        return true;
    }

    public static String identifyCommonSubstr(List<String> strArr) {
        String result = "";
        String smallest = smallestStr(strArr);

        String tempCom = "";
        char[] smallStrChars = smallest.toCharArray();
        for (char c : smallStrChars) {
            tempCom += c;

            if (!occurs(tempCom, strArr)) {
                tempCom = String.valueOf(c);
                if (!occurs(tempCom, strArr)) {
                    tempCom = "";
                }
            }

            if (tempCom != "" && tempCom.length() > result.length()) {
                result = tempCom;
            }
        }

        return result;
    }
}
