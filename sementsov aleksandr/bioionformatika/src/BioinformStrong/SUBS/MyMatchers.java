package BioinformStrong.SUBS;

import java.io.IOException;

public class MyMatchers {

    /** current position in global matching */
    int pos;

    /** buffer of current position for offset */
    int nextPosition;

    /** position in local matching */
    int resultMatching;

    int sizeTargetText;
    int sizeSample;

    String sampleWord;
    String targetText;

    /** choose matcher on your own */
    public enum typeMatchers {
        KnuthMorrisPratt
    }

    int[] prefixFunction(String fragmentWord) {
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
    int kmpMatcher() {
        if (sizeTargetText == 0) {
            return 0;
        }
        int[] prefix = prefixFunction(targetText);
        for (int comparisonIndex = 0, matchingIndex = 0; comparisonIndex < sizeSample; comparisonIndex++)
            for (; ; matchingIndex = prefix[matchingIndex - 1]) {

                // Compare with offset, because every start local matcher resume from position, determined from global matcher.
                if (targetText.charAt(matchingIndex) == sampleWord.charAt(comparisonIndex + nextPosition)) {
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
    int defaultMatcher() {
        return sampleWord.substring(nextPosition).indexOf(targetText);
    }

    public MyMatchers(String sampleWord, String targetText) {
        this.sampleWord = sampleWord;
        this.targetText = targetText;
        sizeSample = sampleWord.length();
        sizeTargetText = targetText.length();
        resultMatching = -1;
        nextPosition = 0;
        pos = -1;
    }

    /** It is global matcher */
    public void letsFind(typeMatchers type_Matchers) throws IOException {

        //prepare to writing
        MyWriter myWriter = null;
        while (true) {
            if (type_Matchers == typeMatchers.KnuthMorrisPratt) {
                resultMatching = kmpMatcher();
            } else {
                resultMatching = defaultMatcher();
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
}
