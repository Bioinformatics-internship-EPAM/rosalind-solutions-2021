//Dataset at the moment:
//A B C D E F G H I J
// 2
package com.company;

public class Main {

    public static void main(String[] args) {
        ExclusiveTxtPrsr.GoParse();
        String alphabet = ExclusiveTxtPrsr.getAlphabet();
        int n = ExclusiveTxtPrsr.getWidth();
        TranslationMap translationMap = new TranslationMap(n, alphabet.length());
        translationMap.GetMap(alphabet);
        MyWriter.QuitRosalind();
    }
}

//Total lines
//46080