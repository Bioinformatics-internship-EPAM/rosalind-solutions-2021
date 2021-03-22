package IPRB;

public class Main {
    public static void main(String[] args) {
        double dominant;
        double recessive;
        double heterozygous;
        try {
            dominant = Integer.parseInt(args[0]);
            heterozygous = Integer.parseInt(args[1]);
            recessive = Integer.parseInt(args[2]);
        } catch (Exception e){
            System.err.println("in args must be 3 integers");
            return;
        }
        double s = dominant + heterozygous + recessive;
        double probability = (2*dominant*heterozygous +
                              2*dominant*recessive +
                              heterozygous*recessive +
                              dominant*(dominant-1) +
                              3*heterozygous*(heterozygous-1)/4) / (s*(s-1));
        System.out.println(probability);
    }
}
