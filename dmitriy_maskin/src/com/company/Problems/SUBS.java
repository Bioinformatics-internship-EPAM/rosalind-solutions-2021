package com.company.Problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SUBS {
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
