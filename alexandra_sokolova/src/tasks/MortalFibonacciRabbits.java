package tasks;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.LinkedList;

public class MortalFibonacciRabbits {
    public static void calculateRabbitPairs(String filepath) {
        String[] numberStrings;
        int months;
        int lifespan;
        try {
            numberStrings = new String(Files.readAllBytes(Paths.get(filepath))).replaceAll("\\s+", " ").split(" ");
            months = Integer.parseInt(numberStrings[0]);
            lifespan = Integer.parseInt(numberStrings[1]);
            if (months <= 0 || lifespan <= 0){
                System.err.println("Two positive integers are expected.");
                return;
            }
        } catch (IOException e) {
            System.err.println("Exception while reading the source number file.");
            return;
        }
        BigInteger reproductivePairs = BigInteger.ZERO;
        BigInteger newPairs = BigInteger.ONE;
        BigInteger litterSize = BigInteger.ONE;
        BigInteger newborns;
        Deque<BigInteger> rabbitsGeneration = new LinkedList<>();
        for (int i = 1; i < months; i++){
            rabbitsGeneration.addFirst(newPairs);
            newborns = reproductivePairs.multiply(litterSize);
            reproductivePairs = reproductivePairs.add(newPairs);
            if (i >= lifespan){
                reproductivePairs = reproductivePairs.subtract(rabbitsGeneration.pollLast());
            }
            newPairs = newborns;
        }
        BigInteger allLitter = reproductivePairs.add(newPairs);
        System.out.println(allLitter);
    }
}
