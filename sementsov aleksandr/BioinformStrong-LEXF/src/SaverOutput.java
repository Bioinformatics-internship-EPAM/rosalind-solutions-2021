package com.company;
import java.io.*;
import java.nio.charset.Charset;

public class SaverOutput {
    static FileWriter writer;

    //здесь нет необходимости использовать try-with-resources statement
    static void goSave() {
        try {
            writer = new FileWriter("output.txt" ,Charset.forName("utf-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void goSave(String fileType) {
        try {
            writer = new FileWriter("output." + fileType, Charset.forName("utf-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static protected void quitRosalind() {
        try {
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
