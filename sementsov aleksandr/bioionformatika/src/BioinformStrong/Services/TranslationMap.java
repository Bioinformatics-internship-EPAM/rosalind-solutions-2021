package BioinformStrong.Services;


import java.io.IOException;
import java.util.Arrays;

//карта, являющаяся фундаментом по предсавлению различных комбинаций данных
public class TranslationMap {

    int[][] translationMap;

    int getFactorial(int length) {
        int res = 1;
        for (int fact = 1; fact < length + 1; fact++) {
            res *= fact;
        }
        return res;
    }

    public int getNumberPermutations(int length) throws IOException {
        MyWriter myWriter = new MyWriter(true);
        int factorialPermutation = getFactorial(length);
        int binaryNumberPermutation = (int) Math.pow(2, length);
        int resultNumberPermutation = factorialPermutation * binaryNumberPermutation;
        myWriter.writeResult(resultNumberPermutation + "\n");
        myWriter.Close();
        return resultNumberPermutation;
    }

    /** To generate same translation map */
    void constructMap(int n, int numeration) {
        translationMap = new int[(int)Math.pow(numeration, n)][n];
        for (int[] mapLine: translationMap) {
            Arrays.fill(mapLine, 0);
        }

        // beginning in i = 1 for first line can be nullable
        for (int i = 1; i < (int)Math.pow(numeration, n); i++) {
            for (int j = n-1; j > -1; j--) {

                //I don't like recursive call (:
                if (translationMap[i][j] != (numeration - 1)) {
                    translationMap[i][j] += 1;
                    break;
                }
                else {
                    translationMap[i][j] = 0;
                }
            }
            if (i+1 <  (int)Math.pow(numeration, n)) {
                System.arraycopy(translationMap[i], 0, translationMap[i+1], 0, translationMap[i].length);
            }
            else { System.out.println("TranslationMap is ready!"); }
        }
    }

    /** To generate same translation map */
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

    /** Initialize translation map */
    public TranslationMap(int width) {
        constructMap(width);
    }

    /** Initialize translation map */
    public TranslationMap(int width, int numeration) {
        constructMap(width, numeration);
    }

    /** Output results to console and dataset-result */
    public void getMap(String alphabet) {
        try {
            MyWriter myWriter = new MyWriter();
            for (int[] ints : translationMap) {
                for (int anInt : ints) {
                    System.out.print(alphabet.charAt(anInt));
                    myWriter.writeResult(alphabet.charAt(anInt));
                }
                System.out.println();
                myWriter.writeResult('\n');
            }
            myWriter.Close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("\n\n\t->\tNot success to write results (look up).");
        }
    }

    /** Output results to console and dataset-result */
    public int getMap(int[] numberArray, int counter) {
        try {
            MyWriter myWriter = new MyWriter(true);
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
