public class MendelFirstLawEvaluator {

  public static double calculateProbability(int k, int m, int n) {
    double total = k + m + n;
    double total2 = total - 1;

    double YyProp = ((m-1) / total2) * 1/4 + (n / total2) * 1/2;
    double yyProp = ((n-1) / total2) + (m / total2) * 1/2;

    return 1 - (m / total) * YyProp - (n / total) * yyProp;
  }
}
