package com.company.Problems;

public class DNA {
    //DNA	Counting DNA Nucleotides
    public static int[] countNucleotides(String s) {
        int[] res = new int[] {0, 0, 0, 0};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                res[0]++;
            if (s.charAt(i) == 'C')
                res[1]++;
            if (s.charAt(i) == 'G')
                res[2]++;
            if (s.charAt(i) == 'T')
                res[3]++;
        }
        return res;
    }
}
