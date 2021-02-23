import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {

        if (args.length < 1) {
            printHelp();
        } else {
            String fileName = "";
            try {
                int functionNumber = Integer.parseInt(args[0]);
                switch (functionNumber) {
                    case 0:
                        fileName = "maksim_prokhorov/datasets/rosalind_dna.txt";
                        System.out.println(Tasks.countingDNANucleotides(getString(fileName)));
                        break;
                    case 1:
                        fileName = "maksim_prokhorov/datasets/rosalind_rna.txt";
                        System.out.println(Tasks.transcribingDNAIntoRNA(getString(fileName)));
                        break;
                    case 2:
                        fileName = "maksim_prokhorov/datasets/rosalind_revc.txt";
                        System.out.println(Tasks.complementingAStrandOfDNA(getString(fileName)));
                        break;
                    case 3:
                        fileName = "maksim_prokhorov/datasets/rosalind_fib.txt";
                        System.out.println(Tasks.rabbitsAndRecurrenceRelations(getString(fileName)));
                        break;
                    case 4:
                        fileName = "maksim_prokhorov/datasets/rosalind_fibd.txt";
                        System.out.println(Tasks.mortalFibonacciRabbits(getString(fileName)));
                        break;
                    case 5:
                        fileName = "maksim_prokhorov/datasets/rosalind_gc.txt";
                        System.out.println(Tasks.computingGCContent(getListOfStrings(fileName)));
                        break;
                    case 6:
                        fileName = "maksim_prokhorov/datasets/rosalind_prot.txt";
                        System.out.println(Tasks.translatingRNAIntoProtein(getString(fileName)));
                        break;
                    case 7:
                        fileName = "maksim_prokhorov/datasets/rosalind_subs.txt";
                        List<String> dataset = getTwoStrings(fileName);
                        System.out.println(Tasks.findingAMotifInDNA(dataset.get(0), dataset.get(1)));
                        break;
                    case 8:
                        fileName = "maksim_prokhorov/datasets/rosalind_hamm.txt";
                        List<String> dataset1 = getTwoStrings(fileName);
                        System.out.println(Tasks.countingPointMutations(dataset1.get(0), dataset1.get(1)));
                        break;
                    case 9:
                        fileName = "maksim_prokhorov/datasets/rosalind_revp.txt";
                        System.out.println(Tasks.locatingRestrictionSites(getMultipleStringsInOne((fileName))));
                        break;
                    default:
                        System.out.println("Unknown function number.");
                        printHelp();
                }
            } catch (IOException ex) {
                System.err.println("Cannot read file: " + fileName);
                ex.printStackTrace();
            }
        }
    }

    private static void printHelp() {
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
                "9: REVP - Locating Restriction Sites";
        System.out.println(helpText);
    }

    private static String getString(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        return fileReader.readLine();
    }

    private static List<String> getTwoStrings(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();
        list.add(fileReader.readLine());
        list.add(fileReader.readLine());
        return list;
    }

    private static String getMultipleStringsInOne(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder dataString = new StringBuilder();
        String str;
        while ((str = fileReader.readLine()) != null) {
            if (str.charAt(0) != '>')
                dataString.append(str);
        }
        return dataString.toString();
    }

    private static List<String> getListOfStrings(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> data = new ArrayList<>();
        StringBuilder dataString = new StringBuilder();
        String str;
        while ((str = fileReader.readLine()) != null) {
            if ((dataString.length() > 0) && (str.charAt(0) == '>')) {
                data.add(dataString.toString());
                dataString = new StringBuilder(str);
            } else {
                dataString.append(str);
            }
        }
        data.add(dataString.toString());
        return data;
    }
}