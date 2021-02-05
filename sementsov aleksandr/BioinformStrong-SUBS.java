//Dataset at the moment:
//CAAGTTTGCACGTAAGTTTGAAGTTTGTCGAAAAGTTTGGGAAAAGTTTGGAGAAGTTTGATTGGGCGTAAAGTTTGAAAGTTTGCAAGTTTGGGAAGTTTGACGAAAAGTTTGAAGTTTGCTGTTTAAAAGTGAAAGTTTGAAGTTTGCAAGTTTGCTAGACCAAAGTTTGAAGTTTGCCAAGTTTGAAAGTTTGGCCAAAAGTTTGGGAAGTTTGAAGTTTGTGAAGTTTGAAGTTTGGAAGTTTGAAGTTTGAAGTTTGTCAAGTTTGAAGTTTGGGTCTGAAGTTTGCAAGTTTGGGAAAGTTTGGTAAGTTTGTGGCCAAGTTTGCAAAGTTTGTGTGTCTAAGTTTGTGTAAGTTTGAAGTTTGAAGTTTGCCCAAGTTTGGTACTCAAAGTTTGTCGAAGTTTGCAAAAGTTTGAAGTTTGGCAAGTTTGACGCCCACATAAGTTTGAAGTTTGGAAGTTTGGCTTTAACAAGTTTGAAGTTTGCAAGTTTGACCGCGTGAAGTTTGAGGAAGTTTGCGGTCAGTAAAAGTTTGAAGTTTGTGGTAAGTTTGAAGTTTGAAGTTTGTAAGTTTGAAAGTTTGCAAGTTTGGGCTTAAGTTTGACAAAGTTTGATAAGTTTGTCGTAAAGTTTGAAGTTTGCCCACCCAGAAGTTTGTCTAAGTTTGTCAAGTTTGTTAAGTTTGTAAGTTTGGAAGTTTGAAAGTTTGGCCTGCAATTCATAAGTTTGAAGTTTGGAGTTAAGTTTGCTGTCAAGTTTGTCGAAGTTTGAAGTTTGTAAAGGTAGCGAAAGTTTGCGATCAAAGTTTGCGAAGTTTGAGGGATGAACTCCCTAAAAGTTTGGATCAAGTTTGAAGTTTGAAAACAAGTTTGCTGGGGAATATCCAAGTTTGGAAGTTTGAAGTTTGCCGTGCAGCTAAGTTTGCTGGTAAGTTTGTAAGTTTG
//AAGTTTGAA
package com.company;
import java.util.*;

public class Main {

    static String getRandomString(Random rnd, int maxlen) {
        int n = rnd.nextInt(maxlen);
        char[] s = new char[n];
        for (int i = 0; i < n; i++)
            s[i] = (char) ('a' + rnd.nextInt(3));
        return new String(s);
    }

    public static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p[i] = k;
        }
        return p;
    }

    //Knuth–Morris–Pratt algorithm
    public static int kmpMatcher(String s, String searchString) {
        //System.out.println(s);
        //System.out.println(searchString);
        int m = searchString.length();
        if (m == 0)
            return 0;
        int[] p = prefixFunction(searchString);
        for (int i = 0, k = 0; i < s.length(); i++)
            for (; ; k = p[k - 1]) {
                if (searchString.charAt(k) == s.charAt(i)) {
                    if (++k == m)
                        return i + 1 - m;
                    break;
                }
                if (k == 0)
                    break;
            }
        return -1;
    }

    public static void main(String[] args) {

        //To load dataset
        String s = "CAAGTTTGCACGTAAGTTTGAAGTTTGTCGAAAAGTTTGGGAAAAGTTTGGAGAAGTTTGATTGGGCGTAAAGTTTGAAAGTTTGCAAGTTTGGGAAGTTTGACGAAAAGTTTGAAGTTTGCTGTTTAAAAGTGAAAGTTTGAAGTTTGCAAGTTTGCTAGACCAAAGTTTGAAGTTTGCCAAGTTTGAAAGTTTGGCCAAAAGTTTGGGAAGTTTGAAGTTTGTGAAGTTTGAAGTTTGGAAGTTTGAAGTTTGAAGTTTGTCAAGTTTGAAGTTTGGGTCTGAAGTTTGCAAGTTTGGGAAAGTTTGGTAAGTTTGTGGCCAAGTTTGCAAAGTTTGTGTGTCTAAGTTTGTGTAAGTTTGAAGTTTGAAGTTTGCCCAAGTTTGGTACTCAAAGTTTGTCGAAGTTTGCAAAAGTTTGAAGTTTGGCAAGTTTGACGCCCACATAAGTTTGAAGTTTGGAAGTTTGGCTTTAACAAGTTTGAAGTTTGCAAGTTTGACCGCGTGAAGTTTGAGGAAGTTTGCGGTCAGTAAAAGTTTGAAGTTTGTGGTAAGTTTGAAGTTTGAAGTTTGTAAGTTTGAAAGTTTGCAAGTTTGGGCTTAAGTTTGACAAAGTTTGATAAGTTTGTCGTAAAGTTTGAAGTTTGCCCACCCAGAAGTTTGTCTAAGTTTGTCAAGTTTGTTAAGTTTGTAAGTTTGGAAGTTTGAAAGTTTGGCCTGCAATTCATAAGTTTGAAGTTTGGAGTTAAGTTTGCTGTCAAGTTTGTCGAAGTTTGAAGTTTGTAAAGGTAGCGAAAGTTTGCGATCAAAGTTTGCGAAGTTTGAGGGATGAACTCCCTAAAAGTTTGGATCAAGTTTGAAGTTTGAAAACAAGTTTGCTGGGGAATATCCAAGTTTGGAAGTTTGAAGTTTGCCGTGCAGCTAAGTTTGCTGGTAAGTTTGTAAGTTTG";
        String searchString = "AAGTTTGAA";

        //To init value for matching
        int matching = -1; //result of matching of current substring
        int i = 0; //offset after current matching result
        int pos1 = -1; //total result with offset

        //To realize loop search all matches
        while (i < s.length()) {

            //Knuth–Morris–Pratt algorithm was selected for matching
            matching = kmpMatcher(s.substring(i), searchString);

            if (matching == -1) {
                System.out.println("End");
                break;
            }

            //if in whole successful, continue loop and offset index of searching
            pos1 = matching + 1 + i;
            //System.out.println(pos1);
            System.out.print(pos1);
            System.out.print(" ");
            i = pos1;
        }
    }
}

//The getting result
//14 71 108 136 166 182 211 227 242 249 265 357 364 415 448 478 535 553 560 575 634 701 729 770 853 860 900