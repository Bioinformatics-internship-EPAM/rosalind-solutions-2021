public class DominantAlleleProbabilityEvaluator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Number of months and rabbit life length as input arguments were expected");
            return;
        }

        int dominant;
        int recessive;
        int heterozygous;

        try {
            dominant = Integer.parseInt(args[0]);
            heterozygous = Integer.parseInt(args[1]);
            recessive = Integer.parseInt(args[2]);
            if (dominant <= 0 || heterozygous <= 0 || recessive <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Two positive integers expected");
            return;
        }

        double k = dominant;
        double m = heterozygous;
        double n = recessive;
        double s = k + m + n;

        double probability = (2*k*m + 2*k*n + m*n + k*(k-1) + 3*m*(m-1)/4)/(s*(s-1));

        System.out.println(probability);
    }
}
