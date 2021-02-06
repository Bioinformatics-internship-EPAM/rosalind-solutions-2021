import java.util.*;
import java.util.stream.Collectors;

public class Solutions {

    //1. Counting DNA Nucleotides http://rosalind.info/problems/dna/
    public static List<Long> getDNANucleotides(String str) {
        List<Long> counts = new ArrayList<>();
        Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        counts.add(map.get("A"));
        counts.add(map.get("C"));
        counts.add(map.get("G"));
        counts.add(map.get("T"));
        return counts;
    }

    //3. The Secondary and Tertiary Structures of DNA http://rosalind.info/problems/revc/
    public static String[] getSecondaryAndTertiaryStructuresOfDNA(String str) {
        String[] strArray = str.split("");
        for (int i = 0; i < strArray.length; i++) {
            switch (strArray[i]) {
                case "A":
                    strArray[i] = "T";
                    break;
                case "C":
                    strArray[i] = "G";
                    break;
                case "G":
                    strArray[i] = "C";
                    break;
                case "T":
                    strArray[i] = "A";
                    break;
            }
        }
        Collections.reverse(Arrays.asList(strArray));
        return strArray;
    }

    //4. Counting Point Mutations http://rosalind.info/problems/hamm/
    public static Integer getHammingDistance(String str1, String str2) throws Exception {
        if (str1.length() != str2.length()) {
            throw new Exception("Strings length aren't equal");
        }
        Integer hammingDist = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                hammingDist++;
            }
        }
        return hammingDist;
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

    public static Map<String, String> codonTable = new HashMap<String, String>() {{
        put("UUU", "F");
        put("CUU", "L");
        put("AUU", "I");
        put("GUU", "V");
        put("UUC", "F");
        put("CUC", "L");
        put("AUC", "I");
        put("GUC", "V");
        put("UUA", "L");
        put("CUA", "L");
        put("AUA", "I");
        put("GUA", "V");
        put("UUG", "L");
        put("CUG", "L");
        put("AUG", "M");
        put("GUG", "V");
        put("UCU", "S");
        put("CCU", "P");
        put("ACU", "T");
        put("GCU", "A");
        put("UCC", "S");
        put("CCC", "P");
        put("ACC", "T");
        put("GCC", "A");
        put("UCA", "S");
        put("CCA", "P");
        put("ACA", "T");
        put("GCA", "A");
        put("UCG", "S");
        put("CCG", "P");
        put("ACG", "T");
        put("GCG", "A");
        put("UAU", "Y");
        put("CAU", "H");
        put("AAU", "N");
        put("GAU", "D");
        put("UAC", "Y");
        put("CAC", "H");
        put("AAC", "N");
        put("GAC", "D");
        put("UAA", "Stop");
        put("CAA", "Q");
        put("AAA", "K");
        put("GAA", "E");
        put("UAG", "Stop");
        put("CAG", "Q");
        put("AAG", "K");
        put("GAG", "E");
        put("UGU", "C");
        put("CGU", "R");
        put("AGU", "S");
        put("GGU", "G");
        put("UGC", "C");
        put("CGC", "R");
        put("AGC", "S");
        put("GGC", "G");
        put("UGA", "Stop");
        put("CGA", "R");
        put("AGA", "R");
        put("GGA", "G");
        put("UGG", "W");
        put("CGG", "R");
        put("AGG", "R");
        put("GGG", "G");
    }};

    //6. Translating RNA into Protein http://rosalind.info/problems/prot/
    public static ArrayList<String> translatingRNAIntoProtein(String rna) {
        ArrayList<String> protein = new ArrayList<String>();
        String aminoAcid = "";
        for (int i = 0; i < rna.length(); i = i + 3) {
            if (!(aminoAcid = codonTable.get(rna.substring(i, i + 3))).equals("Stop")) {
                protein.add(aminoAcid);
            } else {
                break;
            }
        }
        return protein;
    }

    //7. Rabbits and Recurrence Relations http://rosalind.info/problems/fib/
    public static long getRabbitsPopulationsSize(Integer month, Integer childs) {
        long oldold = 1L;
        long old = 1L;
        long current = 0L;
        for (int i = 2; i < month; i++) {
            current = (oldold * childs) + old;
            oldold = old;
            old = current;
        }
        return current;
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
    public static double getCountOfDominantChildes(ArrayList<Integer> countOfCouples) {
        ArrayList<Integer> countOfChildesWithDominantOfEachGenotype = new ArrayList<>(Arrays.asList(4, 4, 4, 3, 2, 0));
        int countOfChildes = 0;
        int countOfChildesWithDominant = 0;
        for (int i = 0; i < countOfCouples.size(); i++) {
            countOfChildesWithDominant += countOfCouples.get(i) * countOfChildesWithDominantOfEachGenotype.get(i);
            countOfChildes += countOfCouples.get(i) * 2;
        }
        double dominantProbability = (double) countOfChildesWithDominant / (2 * countOfChildes);
        return dominantProbability * countOfChildes;
    }

    //10. Calculating Protein Mass http://rosalind.info/problems/prtm/
    public static Map<String, Double> massTable = new HashMap<String, Double>() {{
        put("A", 71.03711);
        put("C", 103.00919);
        put("D", 115.02694);
        put("E", 129.04259);
        put("F", 147.06841);
        put("G", 57.02146);
        put("H", 137.05891);
        put("I", 113.08406);
        put("K", 128.09496);
        put("L", 113.08406);
        put("M", 131.04049);
        put("N", 114.04293);
        put("P", 97.05276);
        put("Q", 128.05858);
        put("R", 156.10111);
        put("S", 87.03203);
        put("T", 101.04768);
        put("V", 99.06841);
        put("W", 186.07931);
        put("Y", 163.06333);
    }};

    public static double calculateProteinMass(List<String> aa_array) {
        double mass = 0;
        for (String aa : aa_array) {
            mass += massTable.get(aa);
        }
        return mass;
    }
}
