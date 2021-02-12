package com.company;

import java.io.Writer;
import java.io.*;

public class MyWriter extends SaverOutput {
    public static void writeResult(char c) {
        try
        {
            writer.append(c);
        }
        catch(Exception ex){

            ex.printStackTrace();
        }
    }

    public static void writeResult(String s) {
        try
        {
            writer.write(s);
        }
        catch(Exception ex){

            ex.printStackTrace();
        }
    }
}
