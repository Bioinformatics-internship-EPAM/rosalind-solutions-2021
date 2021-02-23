package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String c = bufferedReader.readLine();

        char[] cArray = c.toCharArray();

        for (int i = 0; i < cArray.length; i++){
            if (cArray[i] == 'T'){
                cArray[i] = 'U';
            }
        }


        System.out.println(cArray);

    }
}