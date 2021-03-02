package my.rosalind;

public class IntroductionToAlternativeSplicing {
    public int exec(int n, int m) {
        int result = 0;

        int factorialN = getFactorial(n);
        for (int i = m; i <= n; i++) {
            result += (factorialN) / (getFactorial(n - i) * getFactorial(i));
        }

        return result;
    }

    private int getFactorial(int a) {
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        return result;
    }
}
