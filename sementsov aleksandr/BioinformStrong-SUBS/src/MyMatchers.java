package com.company;

public class MyMatchers {

    static int nextPosition;
    static int pos;
    static int resultMatching;

    static int sizeMatch;
    static int sizeSource;

    public enum typeMatchers {
        DEfault,
        KnuthMorrisPratt
    };

    static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p[i] = k;
        }
        return p;
    }

    static int kmpMatcher(String sourceString, String mathchingString) {
        if (sizeMatch == 0)
            return 0;
        int[] p = prefixFunction(mathchingString);
        for (int i = 0, k = 0; i < sizeSource; i++)
            for (; ; k = p[k - 1]) {
                if (mathchingString.charAt(k) == sourceString.charAt(i)) {
                    if (++k == sizeMatch)
                        return i + 1 - sizeMatch;
                    break;
                }
                if (k == 0)
                    break;
            }
        return -1;
    }


    //default matcher
    static int defaultMatcher(String sourceString, String mathchingString) {
        return sourceString.indexOf(mathchingString);
    }

    public static void letsFind(String sourceString, String mathchingString, typeMatchers type_Matchers) {
        sizeSource = sourceString.length();
        sizeMatch = mathchingString.length();
        resultMatching = -1;
        nextPosition = 0;
        pos = -1;
        MyWriter.goSave();
        while (resultMatching < sizeSource) {

            //Knuth–Morris–Pratt algorithm was selected for matching
            if (type_Matchers == typeMatchers.KnuthMorrisPratt) {
                resultMatching = kmpMatcher(sourceString.substring(nextPosition), mathchingString);
            }
            else {
                resultMatching = defaultMatcher(sourceString.substring(nextPosition), mathchingString);
            }

            if (resultMatching == -1) {
                MyWriter.writeResult("End");
                break;
            }

            //if in whole successful, continue loop and offset index of searching
            pos = resultMatching + 1 + nextPosition;
            sizeSource = sizeSource - pos + nextPosition;
            MyWriter.writeResult(Integer.toString(pos) + " ");
            nextPosition = pos;
        }
    }
}
