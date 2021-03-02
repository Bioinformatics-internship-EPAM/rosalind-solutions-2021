package task;

/**
 * Computing GC Content
 * <p>
 * http://rosalind.info/problems/gc/
 */
public class GCContentCalculator {

    /**
     * Calculate GC content
     *
     * @param dna - DNA string contains chars: {'A', 'C', 'G', 'T'}
     * @return - percentage of characters: {'G', 'C'} (multiply by 100)
     */
    public static double calculateGCContent(String dna) {
        return (double) dna.chars().filter(ch -> ch == 'G' || ch == 'C')
                .count() / dna.length() * 100;
    }

}
