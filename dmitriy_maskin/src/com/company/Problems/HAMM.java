package com.company.Problems;

public class HAMM {
    //HAMM	Counting Point Mutations
    public static int hammingDistance(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        return diff;
    }
}
