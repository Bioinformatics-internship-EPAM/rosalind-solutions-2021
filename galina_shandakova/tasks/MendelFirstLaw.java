package tasks;

//Link: http://rosalind.info/problems/iprb/
public class MendelFirstLaw {
    public static double getProbability(int homozygousDominant, int heterozygous, int homozygousRecessive) {
        double homoRecessive2Num = calculateNumberPairCombinations(homozygousRecessive);
        double heterozygous2Num = calculateNumberPairCombinations(heterozygous) * 0.25;
        double homoRecAndHeteroNum = heterozygous * homozygousRecessive * 0.5;
        double allCombinations = calculateNumberPairCombinations(homozygousDominant + heterozygous + homozygousRecessive);
        return 1 - (homoRecessive2Num + homoRecAndHeteroNum + heterozygous2Num) / allCombinations;
    }

    private static double calculateNumberPairCombinations(int x) {
        return (x * (x - 1) / 2d);
    }
}
