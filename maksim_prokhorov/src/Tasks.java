import java.util.*;

public class Tasks {

    // 0 - DNA
    public static String countingDNANucleotides(String dataset) {
        /*
        1 - A
        2 - C
        3 - G
        4 - T
         */
        Map<Character, Integer> count = new HashMap<>() {{
            put('A', 0);
            put('C', 0);
            put('G', 0);
            put('T', 0);
        }};
        for (char ch : dataset.toCharArray()) {
            switch (ch) {
                case 'A':
                    count.replace('A', (count.get('A') + 1));
                    continue;
                case 'C':
                    count.replace('C', (count.get('C') + 1));
                    continue;
                case 'G':
                    count.replace('G', (count.get('G') + 1));
                    continue;
                case 'T':
                    count.replace('T', (count.get('T') + 1));
                    continue;
                default:
                    return "Wrong input line.";

            }
        }
        return count.get('A') + " " + count.get('C') + " " + count.get('G') + " " + count.get('T');
    }

    // 1 - RNA
    public static String transcribingDNAIntoRNA(String dataset) {
        return dataset.replace('T', 'U');
    }

    // 2 - REVC
    public static String complementingAStrandOfDNA(String dataset) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dataset.length(); i++) {
            char ch = dataset.charAt(dataset.length() - i - 1);
            switch (ch) {
                case 'A': {
                    result.append('T');
                    continue;
                }
                case 'T': {
                    result.append('A');
                    continue;
                }
                case 'G': {
                    result.append('C');
                    continue;
                }
                case 'C': {
                    result.append('G');
                }
            }
        }
        return result.toString();
    }

    // 3 - FIB
    public static long rabbitsAndRecurrenceRelations(String dataset) {
        String[] data = dataset.split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                result.add(1L);
            } else {
                result.add(result.get(i - 1) + result.get(i - 2) * k);
            }
        }
        return result.get(result.size() - 1);
    }

    // 4 - FIBD
    public static long mortalFibonacciRabbits(String dataset) {
        String[] data = dataset.split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                result.add(1L);
            } else if (i < m) {
                result.add(result.get(i - 1) + result.get(i - 2));
            } else if (i == m) {
                result.add(result.get(i - 1) + result.get(i - 2) - 1);
            } else {
                result.add(result.get(i - 1) + result.get(i - 2) - result.get(i - m - 1));
            }
        }
        return result.get(result.size() - 1);
    }

    // 5 - GC
    private static final int NAME_LENGTH = 14;

    public static String computingGCContent(List<String> dataset) {
        double bestContent = 0.0;
        String bestContentName = "";
        for (String str : dataset) {
            double content = getContent(str);
            if (content > bestContent) {
                bestContent = content;
                bestContentName = str.substring(1, NAME_LENGTH);
            }
        }
        return bestContentName + "\n" + String.format(Locale.US, "%.6f", bestContent);
    }

    private static double getContent(String string) {
        double numberOfOccurrences = 0.0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'C' || string.charAt(i) == 'G') {
                numberOfOccurrences += 1.0;
            }
        }
        return numberOfOccurrences / (string.length() - NAME_LENGTH) * 100.0;
    }

    // 6 - PROT
    private static Map<String, String> codonTable = new HashMap<String, String>() {{
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

    private static final int CODON_LENGTH = 3;

    public static String translatingRNAIntoProtein(String dataset) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dataset.length(); i += CODON_LENGTH) {
            String key = dataset.substring(i, i + CODON_LENGTH);
            String str = Tasks.codonTable.get(key);
            if (str.equals("Stop")) break;
            result.append(str);
        }
        return result.toString();
    }

    // 7 - SUBS
    public static String findingAMotifInDNA(String string, String seq) {
        int seqLength = seq.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length() - seqLength; i++) {
            if (string.substring(i, i + seqLength).equals(seq)) result.append(i + 1).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

    // 8 - HAMM
    public static int countingPointMutations(String str1, String str2) {
        int length = str1.length();
        if (length != str2.length()) return -1;

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count;
    }

    // 9 - REVP

    private static final int MIN_PALINDROME_LENGTH = 4;
    private static final int MAX_PALINDROME_LENGTH = 12;

    public static String locatingRestrictionSites(String dataset) {
        StringBuilder result = new StringBuilder();
        int datasetLength = dataset.length();
        for (int i = 0; i < datasetLength - 3; i++) {
            int endIndex = (i < datasetLength - MAX_PALINDROME_LENGTH) ? (MAX_PALINDROME_LENGTH + 1) : (datasetLength - i + 1);
            for (int j = MIN_PALINDROME_LENGTH; j < endIndex; j++) {
                String temp = dataset.substring(i, i + j);
                if (temp.equals(Tasks.complementingAStrandOfDNA(temp))) {
                    result.append(i + 1).append(" ").append(j).append("\n");
                }
            }
        }
        return result.toString();
    }
}
