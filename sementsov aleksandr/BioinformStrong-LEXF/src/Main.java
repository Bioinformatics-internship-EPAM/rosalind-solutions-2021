//Dataset at the moment:
//A B C D E F G H I J
// 2
package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ExclusiveTxtPrsr.GoParse();
        char[] alphabet = ExclusiveTxtPrsr.getAlphabet();
        int n = ExclusiveTxtPrsr.getWidth();
        int[] indexes = new int[n];
        int[] elements = new int[n];
        MinusMap minusMap = new MinusMap(n, alphabet.length);
        minusMap.GetMap(alphabet);
        MyWriter.QuitRosalind();
    }
}

//Total lines
//46080