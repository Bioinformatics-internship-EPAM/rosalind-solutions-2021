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

    static String parseAlphabet(Scanner scanner) {
        int c;
        return scanner.nextLine().replaceAll("\s", "");
    }

    static int parseWidth(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void parse(String stringWay) throws IOException {
        try (BufferedReader buffForRead = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(buffForRead);
            parsedAlphabet = parseAlphabet(scanner);
            parsedNumber = parseWidth(scanner);
        }
    }

    public static void goParse() {
        try {
            parse(findDataSet());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void goParse(String stringWay) {
        try {
            parse(stringWay);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getAlphabet() {
        return parsedAlphabet;
    }

    public static int getWidth() {
        return parsedNumber;
    }
}
