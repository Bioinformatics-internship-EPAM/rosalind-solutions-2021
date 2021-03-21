package BioinformStrong.LEXF;

import java.io.IOException;
import java.util.Arrays;

//карта, являющаяся фундаментом по предсавлению различных комбинаций данных
public class TranslationMap {

    int[][] translationMap;

    void constructMap(int n, int numeration) {
        translationMap = new int[MyPower.pow(n,numeration)][n];
        for (int[] mapLine: translationMap) {
            Arrays.fill(mapLine, 0);
        }

        //для того, чтобы первая строка была нулевая, начнём с i=1
        for (int i = 1; i < MyPower.pow(n, numeration); i++) {
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
            if (i+1 <  MyPower.pow(n, numeration)) {
                System.arraycopy(translationMap[i], 0, translationMap[i+1], 0, translationMap[i].length);
            }
            else { System.out.println("TranslationMap is ready!"); }
        }
    }

    TranslationMap(int width, int numeration) {
        constructMap(width, numeration);
    }

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
            System.out.println("\n\n\t->\tне удалось записать результаты (см. выше)");
        }
    }

    /*Во время отладки так и не вызвался
    protected void finalize() {
        System.arraycopy(translationMap, 0, new Object[translationMap.length], 0, translationMap.length);
        translationMap = null;
    }*/
}
