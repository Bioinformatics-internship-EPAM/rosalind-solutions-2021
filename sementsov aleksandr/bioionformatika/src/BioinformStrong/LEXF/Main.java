//Dataset at the moment:
//A B C D E F G H I J
// 2
package BioinformStrong.LEXF;

public class Main {

    public static void main(String[] args) {
        ExclusiveTxtPrsr.goParse();
        String alphabet = ExclusiveTxtPrsr.getAlphabet();
        int n = ExclusiveTxtPrsr.getWidth();
        TranslationMap translationMap = new TranslationMap(n, alphabet.length());
        translationMap.getMap(alphabet);
        MyWriter.quitRosalind();
    }
}
