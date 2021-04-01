package BioinformStrong.LEXF;

import BioinformStrong.Services.*;

public class Main {

    public static void main(String[] args) {
        ExclusiveTxtParser exclusiveTxtParser = new ExclusiveTxtParser();
        String alphabet = exclusiveTxtParser.getAlphabet();
        int n = exclusiveTxtParser.getWidth();
        TranslationMap translationMap = new TranslationMap(n, alphabet.length());
        translationMap.getMap(alphabet);
    }
}
