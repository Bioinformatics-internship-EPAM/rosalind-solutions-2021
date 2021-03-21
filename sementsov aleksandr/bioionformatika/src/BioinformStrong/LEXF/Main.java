package BioinformStrong.LEXF;

public class Main {

    public static void main(String[] args) {
        ExclusiveTxtParser.goParse();
        String alphabet = ExclusiveTxtParser.getAlphabet();
        int n = ExclusiveTxtParser.getWidth();
        TranslationMap translationMap = new TranslationMap(n, alphabet.length());
        translationMap.getMap(alphabet);
    }
}
