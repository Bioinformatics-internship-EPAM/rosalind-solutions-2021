package com.company;

import java.io.Writer;
import java.io.*;

public class MyWriter extends SaverOutput {
    public static void WriteResult(char c) {
        try
        {
            writer.append(c);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void WriteResult(String s) {
        try
        {
            writer.write(s);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
