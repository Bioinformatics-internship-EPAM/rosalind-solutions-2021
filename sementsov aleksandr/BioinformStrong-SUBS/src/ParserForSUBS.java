package com.company;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ParserForSUBS {
    static FileReader reader;
    static Scanner scanner;
    static String parsedSource;
    static String parsedMatch;

    static void parsedMatch() {
        parsedMatch = scanner.nextLine();
    }

    static void parseSource() {
        parsedSource = scanner.nextLine();
        parsedMatch();
    }

    static void parse(String filename) {
        try {
            reader = new FileReader(filename, Charset.forName("utf-8"));
            scanner = new Scanner(reader);
            parseSource();
            scanner.close();
            reader.close();
        }
        catch (Exception e) {

        }
    }

    public static void LetsParse(String pathName) {
        parse(pathName + ".txt");
    }

    public static void LetsParse(String pathName, String typeFile) {
        parse(pathName + typeFile);
    }

    public static String getSource() {
        if (parsedSource != null && parsedSource != "") {
            return parsedSource;
        }
        else {
            parse("rosalind-SUBS");
            System.out.println("dataset wasn't parsed");
            return "";
        }
    }

    public static String getMatch() {
        if (parsedMatch != null && parsedMatch != "") {
            return parsedMatch;
        }
        else {
            parse("rosalind-SUBS");
            System.out.println("dataset wasn't parsed");
            return "";
        }
    }
}
