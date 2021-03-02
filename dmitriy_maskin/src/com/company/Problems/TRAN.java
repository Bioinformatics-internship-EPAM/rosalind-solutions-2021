package com.company.Problems;

public class TRAN {
    // A <-> G & C <-> T – Transitions
    // A <-> C & G <-> T – Transversions
    public static double transversionsKoeff(String s1, String s2) {
        int transitions = 0;
        int transversions = 0;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'A' && s2.charAt(i) == 'G' || s1.charAt(i) == 'G' && s2.charAt(i) == 'A')
                transitions++;
            if (s1.charAt(i) == 'C' && s2.charAt(i) == 'T' || s1.charAt(i) == 'T' && s2.charAt(i) == 'C')
                transitions++;
            if (s1.charAt(i) == 'A' && s2.charAt(i) == 'C' || s1.charAt(i) == 'C' && s2.charAt(i) == 'A')
                transversions++;
            if (s1.charAt(i) == 'G' && s2.charAt(i) == 'T' || s1.charAt(i) == 'T' && s2.charAt(i) == 'G')
                transversions++;
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }

        //System.out.println("Transitions = " + transitions);
        //System.out.println("Transversions = " + transversions);
        //System.out.println("Diff = " + diff);

        return Double.valueOf(diff) / Double.valueOf((transitions + transversions));
    }
}
