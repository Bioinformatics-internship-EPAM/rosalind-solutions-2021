package tasks;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RabbitsandRecurrenceRelations {
    public static void calculateRabbitPairs(String filepath) {
        String[] numberStrings;
        int months;
        BigInteger litterSize;
        try {
            numberStrings = new String(Files.readAllBytes(Paths.get(filepath))).replaceAll("\\s+", " ").split(" ");
            months = Integer.parseInt(numberStrings[0]);
            int litterSizeInt = Integer.parseInt(numberStrings[1]);
            litterSize = BigInteger.valueOf(litterSizeInt);
            if (months <= 0 && litterSizeInt <= 0){
                System.err.println("Two positive integers are expected.");
                return;
            }
        } catch (IOException e) {
            System.err.println("Exception while reading the source number file.");
            return;
        }
        BigInteger reproductivePairs = BigInteger.ZERO;
        BigInteger newPairs = BigInteger.ONE;
        BigInteger newborns;
        for (int i = 1; i < months; i++){
            newborns = reproductivePairs.multiply(litterSize);
            reproductivePairs = reproductivePairs.add(newPairs);
            newPairs = newborns;
        }
        BigInteger allLitter = reproductivePairs.add(newPairs);
        System.out.println(allLitter);
    }
}
