package com.company;

import com.company.Problems.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        byte choice = 127;
        Scanner scanner = new Scanner(System.in);

        while (choice != 0) {

            System.out.println(
                    "0.Exit\n" +
                            "1.DNA\n" +
                            "2.RNA\n" +
                            "3.REVC\n" +
                            "4.HAMM\n" +
                            "5.PROT\n" +
                            "6.SUBS\n" +
                            "7.LCSM\n" +
                            "8.PERM\n" +
                            "9.PPER\n" +
                            "10.TRAN\n");
            choice = scanner.nextByte();

            switch (choice) {
                case 1: {
                    String s1 = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
                    int[] nucleotides = DNA.countNucleotides(s1);
                    for (int i = 0; i < nucleotides.length; i++)
                        System.out.print(nucleotides[i] + " ");
                    System.out.println("\n");
                    break;
                }
                case 2: {
                    String s2 = "GATGGAACTTGACTACGTAAATT";
                    System.out.println(RNA.transcrib(s2));
                    break;
                }
                case 3: {
                    String s3 = "AAAACCCGGT";
                    System.out.println(REVC.complete(s3));
                    break;
                }
                case 4: {
                    String str1 = "GAGCCTACTAACGGGAT";
                    String str2 = "CATCGTAATGACGGCCT";
                    System.out.println(HAMM.hammingDistance(str1, str2));
                    break;
                }
                case 5: {
                    String s = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA";
                    System.out.println(PROT.encodeProteinString(s));
                    break;
                }
                case 6: {
                    String s = "GATATATGCATATACTT";
                    String substr = "ATAT";
                    System.out.println(SUBS.locations(s, substr));
                    break;
                }
                case 7: {
                    String[] strs = new String[]{"GATTACA", "TAGACCA", "ATACA"};
                    System.out.println("(If multiple solutions exist, you may return any single solution.)");
                    System.out.println(LCSM.identifyCommonSubStrOfNStr(strs));
                    break;
                }
                case 8: {
                    String s = "SKADYEK";
                    System.out.println(String.format("%.3f", PRTM.strTotalWeight(s)));
                    break;
                }
                case 9: {
                    int n = 21;
                    int k = 7;
                    System.out.println(PPER.numberPartialPermutations(n, k));
                    break;
                }
                case 10: {
                    String str1 = "GCAACGCACAACGAAAACCCTTAGGGACTGGATTATTTCGTGATCGTTGTAGTTATTGGAAGTACGGGCATCAACCCAGTT";
                    String str2 = "TTATCTGACAAAGAAAGCCGTCAACGGCTGGATAATTTCGCGATCGTGCTGGTTACTGGCGGTACGAGTGTTCCTTTGGGT";
                    System.out.println(TRAN.transversionsKoeff(str1, str2));
                    break;
                }

                default:
                    System.out.println("\n");
                    break;
            }
        }
    }
}
