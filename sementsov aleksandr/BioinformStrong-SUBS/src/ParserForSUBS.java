package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ParserForSUBS {
    static String parsedSource;
    static String parsedMatch;

    static void parsedMatch(Scanner scanner) {
        parsedMatch = scanner.nextLine();
    }

    static void parseSource(Scanner scanner) {
        parsedSource = scanner.nextLine();
        parsedMatch(scanner);
    }

    static void parse(String filename) throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            parseSource(scanner);
        }
    }

    public static void LetsParse(String pathName) {
        try {
            parse(pathName + ".txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LetsParse(String pathName, String typeFile) {
        try {
            parse(pathName + typeFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSource() {
        if (parsedSource != null && parsedSource != "") {
            return parsedSource;
        }
        else {
            try {
                parse("rosalind-SUBS");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("dataset wasn't parsed");
            return "";
        }
    }

    public static String getMatch() {
        if (parsedMatch != null && parsedMatch != "") {
            return parsedMatch;
        }
        else {
            try {
                parse("rosalind-SUBS");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("dataset wasn't parsed");
            return "";
        }
    }
}
