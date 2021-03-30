package BioinformStrong.SUBS;

import java.io.IOException;

public class MyMatchers {

    /** current position in global matching */
    static int pos;

    /** buffer of current position for offset */
    static int nextPosition;

    /** position in local matching */
    static int resultMatching;

    static int sizeTargetText;
    static int sizeSample;

    public enum typeMatchers {
        KnuthMorrisPratt
    }

    static int[] prefixFunction(String fragmentWord) {
        int[] prefix = new int[fragmentWord.length()];
        int greatestProper = 0;
        for (int prefixPosition = 1; prefixPosition < fragmentWord.length(); prefixPosition++) {
            while (greatestProper > 0 && fragmentWord.charAt(greatestProper) != fragmentWord.charAt(prefixPosition))
                greatestProper = prefix[greatestProper - 1];
            if (fragmentWord.charAt(greatestProper) == fragmentWord.charAt(prefixPosition))
                ++greatestProper;
            prefix[prefixPosition] = greatestProper;
        }
        return prefix;
    }
    // Which:
    // prefixPosition - is position, which is calculated greatest proper;
    // greatestProper - is number, which is determined size of repeated sequence.

    /** It is local matcher */
    static int kmpMatcher(String sampleWord, String targetText) {
        if (sizeTargetText == 0)
            return 0;
        int[] prefix = prefixFunction(targetText);
        for (int comparisonIndex = 0, matchingIndex = 0; comparisonIndex < sizeSample; comparisonIndex++)
            for (; ; matchingIndex = prefix[matchingIndex - 1]) {
                if (targetText.charAt(matchingIndex) == sampleWord.charAt(comparisonIndex)) {
                    if (++matchingIndex == sizeTargetText)
                        return comparisonIndex + 1 - sizeTargetText;
                    break;
                }
                if (matchingIndex == 0)
                    break;
            }
        return -1;
    }
    // Which:
    // comparisonIndex - is position, which compare strings at the moment;
    // matchingIndex - is end-position after comparing sample with target text.


    /** It is local matcher */
    static int defaultMatcher(String sourceString, String matchingString) {
        return sourceString.indexOf(matchingString);
    }

    /** It is global matcher */
    public static void letsFind(String sampleWord, String targetText, typeMatchers type_Matchers) {
        sizeSample = sampleWord.length();
        sizeTargetText = targetText.length();
        resultMatching = -1;
        nextPosition = 0;
        pos = -1;
        try {

            //prepare to writing
            MyWriter myWriter = null;
            while (true) {
                if (type_Matchers == typeMatchers.KnuthMorrisPratt) {
                    resultMatching = kmpMatcher(sampleWord.substring(nextPosition), targetText);
                } else {
                    resultMatching = defaultMatcher(sampleWord.substring(nextPosition), targetText);
                }
                if (resultMatching < 0) {
                    System.out.println("End");
                    break;
                }

                //if in whole successful, continue loop and offset index of searching
                pos = resultMatching + nextPosition + 1;
                sizeSample = sizeSample - (pos - nextPosition);
                if (myWriter == null) {
                    myWriter = new MyWriter();
                    myWriter.writeResult(Integer.toString(pos));
                }
                else {
                    myWriter.writeResult("\s" + pos);
                }
                nextPosition = pos;
            }
            if (myWriter != null) {
                myWriter.Close();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
