package LCSM;

import utils.Utils;

import java.util.List;

public class LCSM {
    private static final String FILE_NAME = "lcsm_input.txt";
    private static final String FILE_PATH = "src/LCSM/" + FILE_NAME;

    public static void main(String[] args) throws Exception {
        List<String> strs = Utils.readFromFile(FILE_PATH);

        System.out.println("(If multiple solutions exist, you may return any single solution.)");

        System.out.println(LCSM.identifyCommonSubStrOfNStr(strs));
    }

    public static String identifyCommonSubStrOfNStr(List<String> strArr){

        String commonStr="";
        String smallStr ="";

        //identify smallest String
        for (String s :strArr) {
            if(smallStr.length()< s.length()){
                smallStr=s;
            }
        }

        String tempCom="";
        char [] smallStrChars = smallStr.toCharArray();
        for (char c: smallStrChars) {
            tempCom += c;

            for (String s :strArr) {
                if(!s.contains(tempCom)) {
                    tempCom = String.valueOf(c);
                    for (String string :strArr) {
                        if(!string.contains(tempCom)) {
                            tempCom="";
                            break;
                        }
                    }
                    break;
                }
            }

            if(tempCom != "" && tempCom.length()>commonStr.length()){
                commonStr=tempCom;
            }
        }

        return commonStr;
    }
}
