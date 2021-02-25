package my.rosalind;

public class WrightFishersExpectedBehavior {
    public double[] exec(int n, double[] p) {
        var result = new double[p.length];
        for (int i = 0; i < p.length; i++) {
            result[i] = n * p[i];
        }
        return result;
    }
}
