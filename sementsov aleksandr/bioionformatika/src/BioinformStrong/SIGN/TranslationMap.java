package BioinformStrong.SIGN;

import java.io.IOException;
import java.util.Arrays;

public class TranslationMap {

    int getFactorial(int length) {
        int res = 1;
        for (int fact = 1; fact < length + 1; fact++) {
            res *= fact;
        }
        return res;
    }

    public int getNumberPermutations(int length) throws IOException {
        MyWriter myWriter = new MyWriter();
        int factorialPermutation = getFactorial(length);
        int binaryNumberPermutation = (int) Math.pow(2, length);
        int resultNumberPermutation = factorialPermutation * binaryNumberPermutation;
        myWriter.writeResult(resultNumberPermutation + "\n");
        myWriter.Close();
        return resultNumberPermutation;
    }

    int[][] translationMap;

    void constructMap(int n) {
        translationMap = new int[(int)Math.pow(2, n)][n];
        for (int i = 0; i < (int)Math.pow(2, n); i++) {
            Arrays.fill(translationMap[i], 0);
        }

        //для того, чтобы первая строка была нулевая, начнём с i=1
        for (int i = 1; i < (int)Math.pow(2, n); i++) {
            for (int j = n-1; j > -1; j--) {

                //I don't like recursive call (:
                if (translationMap[i][j] != (2 - 1)) {
                    translationMap[i][j] += 1;
                    break;
                }
                else {
                    translationMap[i][j] = 0;
                }
            }
            if (i+1 <  (int)Math.pow(2, n)) {
                System.arraycopy(translationMap[i], 0, translationMap[i+1], 0, translationMap[i].length);
            }
            else { System.out.println("TranslationMap is ready!"); }
        }
    }

    TranslationMap(int width) {
        constructMap(width);
    }

    public int getMap(int[] numberArray, int counter) {
        try {
            MyWriter myWriter = new MyWriter();
            for (int[] ints : translationMap) {
                for (int j = 0; j < ints.length; j++) {
                    if (ints[j] == 0) {
                        System.out.print(numberArray[j] * (-1));
                        myWriter.writeResult("-");
                    } else {
                        System.out.print(numberArray[j]);
                    }
                    myWriter.writeResult(Integer.toString(numberArray[j]));
                    System.out.print(" ");
                    myWriter.writeResult("\s");
                }
                counter++;
                System.out.println();
                myWriter.writeResult("\n");
            }
            myWriter.Close();
            return counter;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}
