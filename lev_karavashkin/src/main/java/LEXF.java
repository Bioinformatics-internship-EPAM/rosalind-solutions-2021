import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LEXF {

    public static List<String> getOrdered(char[] list, int n) {

        char[] data=new char[n];
        List<String> resultArr = new ArrayList<>();

        getCombinations(list, data, 0, n,resultArr);
        resultArr.sort(Comparator.comparing( String::toString ));

        return resultArr;
    }

    private static void getCombinations(char[] list, char[] temp,
                                        int idx, int n, List<String> resArr) {
        if (idx == n) {
            resArr.add(String.valueOf(temp));
            return;
        }

        for (int i=0; i<=list.length - 1; i++)
        {
            temp[idx] = list[i];
            getCombinations(list, temp, idx+1, n,resArr);
        }
    }
}
