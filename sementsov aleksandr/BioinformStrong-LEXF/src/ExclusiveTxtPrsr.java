package com.company;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ExclusiveTxtPrsr {

    static String parsedAlphabet;
    static int parsedNumber;

    static String findDataSet() {
        String directory = System.getProperty("user.dir");
        String[] files = new File(directory).list();
        String res = "";
        for (int i = 0; i < files.length; i++) {
            if (files[i].indexOf("rosalind") != -1) {
                res = files[i];
                break;
            }
        }
        return res;
    }

    static String ParseAlphabet(Scanner scanner) {
        int c;
        return scanner.nextLine().replaceAll("\s", "");
    }

    static int ParseWidth(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void Parse(String stringWay) {
        try {
            FileReader reader = new FileReader(stringWay, Charset.forName("utf-8"));
            Scanner scanner = new Scanner(reader);
            parsedAlphabet = ParseAlphabet(scanner);
            parsedNumber = ParseWidth(scanner);
            scanner.close();
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

    public static String getAlphabet() {
        return parsedAlphabet;
    }

    public static int getWidth() {
        return parsedNumber;
    }
}
