package tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MendelsFirstLaw {
    public static void calculateProbability(String filepath) {
        String[] numberStrings;
        int dominant ;
        int heterozygous;
        int recessive;
        try {
            numberStrings = new String(Files.readAllBytes(Paths.get(filepath))).replaceAll("\\s+", " ").split(" ");
            dominant = Integer.parseInt(numberStrings[0]);
            heterozygous = Integer.parseInt(numberStrings[1]);
            recessive = Integer.parseInt(numberStrings[2]);
            if (dominant <= 0 || heterozygous <= 0 || recessive <= 0){
                System.err.println("Three positive integers are expected.");
                return;
            }
        } catch (IOException e) {
            System.err.println("Exception while reading the source number file.");
            return;
        }
        double k = dominant;
        double m = heterozygous;
        double n = recessive;
        double population = k + m + n;
        double numerator = 2*k*m + 2*k*n + m*n + k*(k-1) + 3*m*(m-1)/4;
        double denominator = population*(population-1);
        double probability = numerator/denominator;
        System.out.println(probability);
    }
}
