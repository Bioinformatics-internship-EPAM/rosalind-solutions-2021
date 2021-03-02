package task;

/**
 * Rabbits and Recurrence Relations
 *
 * http://rosalind.info/problems/fib/
 */
public class RabbitPopulationCalculator {

    /**
     *
     * @param monthsCount - count of months ≤ 40
     * @param litter - count pairs that reproduction-age rabbits produces. Count ≤ 5
     * @return - the total number of rabbit pairs after monthsCount
     */
    public static long calculate(final int monthsCount, final int litter) {
        long youngRabbits = 1;
        long reproductionRabbits = 0;
        long newRabbits;
        for (int i = 1; i < monthsCount; i++) {
            newRabbits = reproductionRabbits * litter;
            reproductionRabbits  += youngRabbits;
            youngRabbits = newRabbits;
        }
        return youngRabbits + reproductionRabbits;
    }

}
