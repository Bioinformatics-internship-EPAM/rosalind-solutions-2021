package com.company;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class ExclusiveTxtPrsr {

    static char[] parsedAlphabet;
    static int parsedNumber;

    static String findDataSet() {
        File file = new File("aabbbbbaaa.txt");
        String directory = file.getAbsolutePath();
        String[] directoryStructure = directory.split("/");
        String pathCollection = "";
        for (int i = 1; i < directoryStructure.length - 1; i++) {
            pathCollection += '/';
            pathCollection += directoryStructure[i];
        }
        String[] files = new File(pathCollection).list();
        String res = "";
        for (int i = 0; i < files.length; i++) {
            if (files[i].indexOf("rosalind") != -1) {
                res = files[i];
                break;
            }
        }
        return res;
    }

    static char[] ParseAlphabet(FileReader reader) {
        int c;
        String alphabet = "";
        try {
            while((c=reader.read()) != '\n'){
                if (c != ' ') {
                    alphabet += (char)c;
                }
            }
            return alphabet.toCharArray();
        }
        catch(IOException ex) {
            return ex.getMessage().toCharArray();
        }
    }

    static int ParseWidth(FileReader reader) {
        int c;
        String width = "";
        try {
            while((c=reader.read()) != '\n'){
                if (c != ' ') {
                    width += (char)c;
                }
            }
            return Integer.parseInt(width);
        }
        catch(IOException ex) {
            return -1;
        }
    }

    //
    // Builder for parser
    public static void Parse(String stringWay) {
        try {
            FileReader reader = new FileReader(stringWay, Charset.forName("utf-8"));
            parsedAlphabet = ParseAlphabet(reader);
            parsedNumber = ParseWidth(reader);
            reader.close();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void GoParse() {
        Parse(findDataSet());
    }

    public static void GoParse(String stringWay) {
        Parse(stringWay);
    }
    //

    public static char[] getAlphabet() {
        return parsedAlphabet;
    }

    public static int getWidth() {
        return parsedNumber;
    }
}
