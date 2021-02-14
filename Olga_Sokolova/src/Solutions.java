import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions {

    //1. Counting DNA Nucleotides http://rosalind.info/problems/dna/
    public static List<Long> getDNANucleotides(String str) {
        Map<Character, Long> map = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return List.of(map.get('A'), map.get('C'), map.get('G'), map.get('T'));
    }

    //2. Transcribing DNA into RNA http://rosalind.info/problems/rna/
    public static String transcribeDNAIntoRNA(String dnaString) {
        return dnaString.replace('T', 'U');
    }

    //3. The Secondary and Tertiary Structures of DNA http://rosalind.info/problems/revc/
    public static char[] getSecondaryAndTertiaryStructuresOfDNA(String dnaChain) {
        char[] dnaNucleotides = dnaChain.toCharArray();
        int stringLength = dnaNucleotides.length;
        char[] reverseDNA = new char[stringLength];
        for (int i = 0; i < stringLength; i++) {
            reverseDNA[stringLength - i - 1] = Constants.complementary.get(dnaNucleotides[i]);
        }
        return reverseDNA;
    }

    //4. Counting Point Mutations http://rosalind.info/problems/hamm/
    public static long getHammingDistance(String dnaString1, String dnaString2) throws IllegalArgumentException {
        if (dnaString1.length() != dnaString2.length()) {
            throw new IllegalArgumentException("Strings length aren't equal");
        }
        return IntStream.range(0, dnaString1.length())
                .filter(i -> dnaString1.charAt(i) != dnaString2.charAt(i))
                .count();
    }

    //5. Finding a Motif in DNA http://rosalind.info/problems/subs/
    public static ArrayList<Integer> findingMotifInDNA(String str, String substring) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < str.length() - substring.length() + 1; i++) {
            if (str.startsWith(substring, i)) {
                positions.add(i + 1);
            }
        }
        return positions;
    }

    static final int CODON_LENGTH = 3;
    static final String STOP_CODON = "Stop";

    //6. Translating RNA into Protein http://rosalind.info/problems/prot/
    public static ArrayList<String> translatingRNAIntoProtein(String rna) {
        ArrayList<String> protein = new ArrayList<>();
        String aminoAcid = "";
        for (int i = 0; i < rna.length(); i = i + CODON_LENGTH) {
            aminoAcid = getCodon(rna.substring(i, i + CODON_LENGTH));
            if (!(aminoAcid.equals(STOP_CODON))) {
                protein.add(aminoAcid);
            } else {
                break;
            }
        }
        return protein;
    }

    public static String getCodon(String rnaSubstring) {
        return Constants.codonTable.get(rnaSubstring);
    }

    //7. Rabbits and Recurrence Relations http://rosalind.info/problems/fib/
    public static long getRabbitsPopulationsSize(Integer month, Integer children) {
        long ancestor = 1L;
        long current = 1L;
        long descendant = 0L;
        for (int i = 2; i < month; i++) {
            descendant = (ancestor * children) + current;
            ancestor = current;
            current = descendant;
        }
        return descendant;
    }

    //8. Introduction to Mendelian Inheritance http://rosalind.info/problems/iprb/
    public static double getMendelProbability(int k, int m, int n) {
        double allOrganisms = k + m + n;
        double nn_probability = (k / allOrganisms) * ((k - 1) / (allOrganisms - 1));
        double mm_probability = (m / allOrganisms) * ((m - 1) / (allOrganisms - 1));
        double mn_probability = (m / allOrganisms) * (n / (allOrganisms - 1)) + (n / allOrganisms) * (m / (allOrganisms - 1));
        double rec_prog = nn_probability + mm_probability * 1 / 4 + mn_probability * 1 / 2;
        return 1 - rec_prog;
    }

    //9. Calculating Expected Offspring http://rosalind.info/problems/iev/
    public static double getCountOfDominantChildren(ArrayList<Integer> countOfCouples) {
        List<Integer> countOfChildrenWithDominantOfEachGenotype = List.of(4, 4, 4, 3, 2, 0);
        int allChildren = 0;
        int childrenWithDominant = 0;
        for (int i = 0; i < countOfCouples.size(); i++) {
            childrenWithDominant += countOfCouples.get(i) * countOfChildrenWithDominantOfEachGenotype.get(i);
            allChildren += countOfCouples.get(i) * 2;
        }
        double dominantProbability = (double) childrenWithDominant / (2 * allChildren);
        return dominantProbability * allChildren;
    }

    //10. Calculating Protein Mass http://rosalind.info/problems/prtm/
    public static double calculateProteinMass(List<String> aa_array) {
        double mass = 0;
        for (String aa : aa_array) {
            mass += Constants.massTable.get(aa);
        }
        return mass;
    }
}