public class RabbitPairsEvaluator {
    public static long evaluate(long months, long produceMultiplier) {
        long numberOfReproductiveRabbitPairs = 0;
        long numberOfNewbornRabbitPairs = 1;
        for (int i = 1; i < months; i++) {
            long bornPairs = numberOfReproductiveRabbitPairs * produceMultiplier;
            numberOfReproductiveRabbitPairs += numberOfNewbornRabbitPairs;
            numberOfNewbornRabbitPairs = bornPairs;
        }

        return numberOfReproductiveRabbitPairs + numberOfNewbornRabbitPairs;
    }
}
