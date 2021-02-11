package com.company;

public class Main {

    public static void main(String[] args) {

        //To load dataset
        ParserForSUBS.LetsParse("rosalind-SUBS");
        String s = ParserForSUBS.getSource();
        String searchString = ParserForSUBS.getMatch();

        MyMatchers.letsFind(s, searchString, MyMatchers.typeMatchers.KnuthMorrisPratt);
        MyWriter.quitRosalind();
    }
}