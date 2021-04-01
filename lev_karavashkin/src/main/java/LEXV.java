import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEXV {

    public static List<String> getOrdered(char[] list, int n) {

        char[] data=new char[n];
        List<String> resultArr = new ArrayList<>();

        getCombinations(list, data, 0, n,resultArr);

        return resultArr;
    }

    private static void getCombinations(char[] list, char[] temp,
                                        int idx, int n, List<String> resArr) {
        if(idx != 0){
            resArr.add(String.valueOf(Arrays.copyOfRange(temp, 0, idx)));
        }
        if (idx == n) {
            return;
        }

        for (int i=0; i<=list.length - 1; i++)
        {
            temp[idx] = list[i];
            getCombinations(list, temp, idx+1, n,resArr);
        }
    }

    public static void main(String[] args) {
        List<String> strArr = LEXV.getOrdered(new char[]{'D','N','A'},3);

        for (String str: strArr
             ) {
            System.out.println(str);
        }

    }
}
