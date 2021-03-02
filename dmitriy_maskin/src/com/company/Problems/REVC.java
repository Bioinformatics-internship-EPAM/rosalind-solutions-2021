package com.company.Problems;

public class REVC {
    //REVC	Complementing a Strand of DNA
    public static String complete(String s) {
        StringBuilder sReverse = new StringBuilder(s).reverse();
        String res = "";
        for (int i = 0; i < sReverse.length(); i++) {
            if (sReverse.charAt(i) == 'A') {
                res += 'T';
                continue;
            }
            if (sReverse.charAt(i) == 'C') {
                res += 'G';
                continue;
            }
            if (sReverse.charAt(i) == 'T') {
                res += 'A';
                continue;
            }
            if (sReverse.charAt(i) == 'G') {
                res += 'C';
                continue;
            }
        }
        return res;
    }
}
