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
        char[] DNAstring = c.toCharArray();

        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;

        for (int i = 0; i < DNAstring.length; i++){
            if (DNAstring[i] == 'A'){
                countA ++;
            }
            else if (DNAstring[i] == 'C'){
                countC ++;
            }
            else if (DNAstring[i] == 'G'){
                countG ++;
            }
            else{
                countT ++;
            }
        }


        System.out.print(countA + " " + countC + " "+ countG + " " + countT);

    }
}