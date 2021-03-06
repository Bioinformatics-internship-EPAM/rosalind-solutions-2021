public class DominantAlleleProbabilityCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Three positive integers as input arguments expected");
        }

        int dominant;
        int recessive;
        int heterozygous;

        try {
            dominant = Integer.parseInt(args[0]);
            heterozygous = Integer.parseInt(args[1]);
            recessive = Integer.parseInt(args[2]);
            if (dominant <= 0 || heterozygous <= 0 || recessive <= 0) {
                System.err.println("Positive integers expected");
            }
        } catch (NumberFormatException e) {
            System.err.println("Three integers expected");
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
