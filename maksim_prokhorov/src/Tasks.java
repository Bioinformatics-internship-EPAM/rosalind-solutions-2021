import java.io.IOException;
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
        for (int i = 0; i < dataset.length(); i++) {
            char ch = dataset.charAt(i);
            if (!count.containsKey(ch)) {
                return "Wrong input line.";
            }
            count.merge(ch, 1, Integer::sum);
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
            String substring = string.substring(i, i + seqLength);
            if (substring.equals(seq)) result.append(i + 1).append(" ");
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

    // 10 - ORF
    private static final String START_CODON = "AUG";
    private static final int MIN_PROTEIN_LENGTH = 1;

    public static Set<String> openReadingFrames(String dataset) {
        String rnaString = transcribingDNAIntoRNA(dataset);
        Set<String> result = new HashSet<>();

        List<Integer> startIndexes = new ArrayList<>();
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = rnaString.indexOf(START_CODON, lastIndex);
            if (lastIndex != -1) {
                startIndexes.add(lastIndex);
                lastIndex += 1;
            }
        }

        List<Integer> complementStartIndexes = new ArrayList<>();
        String reverseComplementString = complementingAStrandOfDNA(dataset);
        String reverseComplementRNAString = transcribingDNAIntoRNA(reverseComplementString);
        lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = reverseComplementRNAString.indexOf(START_CODON, lastIndex);
            if (lastIndex != -1) {
                complementStartIndexes.add(lastIndex);
                lastIndex += 1;
            }
        }

        for (int index : startIndexes) {
            StringBuilder proteinString = new StringBuilder();
            for (int i = index; i < rnaString.length() - CODON_LENGTH; i += CODON_LENGTH) {
                String key = rnaString.substring(i, i + CODON_LENGTH);
                String str = Tasks.codonTable.get(key);
                if (str.equals("Stop")) {
                    if (proteinString.length() >= MIN_PROTEIN_LENGTH) {
                        result.add(proteinString.toString());
                    }
                    break;
                }
                proteinString.append(str);
            }
        }

        for (int index : complementStartIndexes) {
            StringBuilder proteinString = new StringBuilder();
            for (int i = index; i < reverseComplementRNAString.length() - CODON_LENGTH; i += CODON_LENGTH) {
                String key = reverseComplementRNAString.substring(i, i + CODON_LENGTH);
                String str = Tasks.codonTable.get(key);
                if (str.equals("Stop")) {
                    if (proteinString.length() >= MIN_PROTEIN_LENGTH) {
                        result.add(proteinString.toString());
                    }
                    break;
                }
                proteinString.append(str);
            }
        }
        return result;
    }

    // 11 - PRTM
    private static Map<Character, Double> massTable = new HashMap<Character, Double>() {{
        put('A', 71.03711);
        put('C', 103.00919);
        put('D', 115.02694);
        put('E', 129.04259);
        put('F', 147.06841);
        put('G', 57.02146);
        put('H', 137.05891);
        put('I', 113.08406);
        put('K', 128.09496);
        put('L', 113.08406);
        put('M', 131.04049);
        put('N', 114.04293);
        put('P', 97.05276);
        put('Q', 128.05858);
        put('R', 156.10111);
        put('S', 87.03203);
        put('T', 101.04768);
        put('V', 99.06841);
        put('W', 186.07931);
        put('Y', 163.06333);
    }};

    static String calculatingProteinMass(String dataset) {
        double result = 0.0;
        for (char ch : dataset.toCharArray()) {
            result += massTable.get(ch);
        }
        return String.format(Locale.US,"%.3f", result);
    }

    static String callFunction(int taskNumber) throws IOException {
        String fileName;
        switch (taskNumber) {
            case 0:
                fileName = "maksim_prokhorov/datasets/rosalind_dna.txt";
                return Tasks.countingDNANucleotides(IO.getString(fileName));
            case 1:
                fileName = "maksim_prokhorov/datasets/rosalind_rna.txt";
                return Tasks.transcribingDNAIntoRNA(IO.getString(fileName));
            case 2:
                fileName = "maksim_prokhorov/datasets/rosalind_revc.txt";
                return Tasks.complementingAStrandOfDNA(IO.getString(fileName));
            case 3:
                fileName = "maksim_prokhorov/datasets/rosalind_fib.txt";
                return Tasks.rabbitsAndRecurrenceRelations(IO.getString(fileName)) + "";
            case 4:
                fileName = "maksim_prokhorov/datasets/rosalind_fibd.txt";
                return Tasks.mortalFibonacciRabbits(IO.getString(fileName)) + "";
            case 5:
                fileName = "maksim_prokhorov/datasets/rosalind_gc.txt";
                return Tasks.computingGCContent(IO.getListOfStrings(fileName));
            case 6:
                fileName = "maksim_prokhorov/datasets/rosalind_prot.txt";
                return Tasks.translatingRNAIntoProtein(IO.getString(fileName));
            case 7:
                fileName = "maksim_prokhorov/datasets/rosalind_subs.txt";
                List<String> dataset = IO.getTwoStrings(fileName);
                return Tasks.findingAMotifInDNA(dataset.get(0), dataset.get(1));
            case 8:
                fileName = "maksim_prokhorov/datasets/rosalind_hamm.txt";
                List<String> dataset1 = IO.getTwoStrings(fileName);
                return Tasks.countingPointMutations(dataset1.get(0), dataset1.get(1)) + "";
            case 9:
                fileName = "maksim_prokhorov/datasets/rosalind_revp.txt";
                return Tasks.locatingRestrictionSites(IO.getMultipleStringsInOne((fileName)));
            default:
                return "Unknown function number.\n" + printHelp();
        }
    }

    static String printHelp() {
        String helpText = "Use number [0-9] in program args to call function:\n" +
                "0: DNA  - Counting DNA Nucleotides\n" +
                "1: RNA  - Transcribing DNA into RNA\n" +
                "2: REVC - Complementing a Strand of DNA\n" +
                "3: FIB  - Rabbits and Recurrence Relations\n" +
                "4: FIBD - Mortal Fibonacci Rabbits\n" +
                "5: GC   - Computing GC Content\n" +
                "6: PROT - Translating RNA into Protein\n" +
                "7: SUBS - Finding a Motif in DNA\n" +
                "8: HAMM - Counting Point Mutations\n" +
                "9: REVP - Locating Restriction Sites\n" +
                "10: ORF - Open Reading Frames\n" +
                "11: PRTM - Calculating ProteinMass";
        return helpText;
    }
}
