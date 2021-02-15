import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<String> readFile(String path) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.collect(Collectors.toList());
        }
    }

    public static void runTask(int taskNumber, List<String> fileLines) {
        switch (taskNumber) {
            case 1:
                //1. Counting DNA Nucleotides http://rosalind.info/problems/dna/
                Solutions.getDNANucleotides(fileLines.get(0)).forEach(s -> System.out.printf("%s ", s));
                System.out.println();
                break;
            case 2:
                //2. Transcribing DNA into RNA http://rosalind.info/problems/rna/
                System.out.println(Solutions.transcribeDNAIntoRNA(fileLines.get(0)));
                break;
            case 3:
                //3. The Secondary and Tertiary Structures of DNA http://rosalind.info/problems/revc/
                System.out.println(Solutions.getSecondaryAndTertiaryStructuresOfDNA(fileLines.get(0)));
                break;
            case 4:
                //4. Counting Point Mutations http://rosalind.info/problems/hamm/
                String str1 = fileLines.get(0);
                String str2 = fileLines.get(1);
                System.out.println(Solutions.getHammingDistance(str1, str2));
                break;
            case 5:
                //5. Finding a Motif in DNA http://rosalind.info/problems/subs/
                String str0 = fileLines.get(0);
                String substr = fileLines.get(1);
                Solutions.findingMotifInDNA(str0, substr).forEach(s -> System.out.printf("%s ", s));
                System.out.println();
                break;
            case 6:
                //6. Translating RNA into Protein http://rosalind.info/problems/prot/
                Solutions.translatingRNAIntoProtein(fileLines.get(0)).forEach(s -> System.out.printf("%s", s));
                System.out.println();
                break;
            case 7:
                //7. Rabbits and Recurrence Relations http://rosalind.info/problems/fib/
                String[] params = fileLines.get(0).split(" ");
                System.out.println(Solutions.getRabbitsPopulationsSize(Integer.parseInt(params[0]), Integer.parseInt(params[1])));
                break;
            case 8:
                //8. Introduction to Mendelian Inheritance http://rosalind.info/problems/iprb/
                params = fileLines.get(0).split(" ");
                int k = Integer.parseInt(params[0]);
                int m = Integer.parseInt(params[1]);
                int n = Integer.parseInt(params[2]);
                System.out.println(Solutions.getMendelProbability(k, m, n));
                break;
            case 9:
                //9. Calculating Expected Offspring http://rosalind.info/problems/iev/
                params = fileLines.get(0).split(" ");
                ArrayList<Integer> countOfCouples = new ArrayList<>();
                for (String param : params) {
                    countOfCouples.add(Integer.parseInt(param));
                }
                System.out.printf("%f%n", Solutions.getCountOfDominantChildren(countOfCouples));
                break;
            case 10:
                //10. Calculating Protein Mass http://rosalind.info/problems/prtm/
                List<String> aa_array = Arrays.asList(fileLines.get(0).split(""));
                System.out.println(Solutions.calculateProteinMass(aa_array));
                break;
        }
    }

    public static void main(String[] args) {
        String task1_path = "dataset/rosalind_dna.txt";
        String task2_path = "datasets/rosalind_rna.txt";
        String task3_path = "datasets/rosalind_revc.txt";
        String task4_path = "datasets/rosalind_hamm.txt";
        String task5_path = "datasets/rosalind_subs.txt";
        String task6_path = "datasets/rosalind_prot.txt";
        String task7_path = "datasets/rosalind_fib.txt";
        String task8_path = "datasets/rosalind_iprb.txt";
        String task9_path = "datasets/rosalind_iev.txt";
        String task10_path = "datasets/rosalind_prtm.txt";

        List<String> fileLines = null;
        try {
            fileLines = readFile(task1_path);
        } catch (IOException e) {
            System.err.println("Can't open file " + task1_path);
            System.err.println(e.getMessage());
        }
        if (fileLines != null) {
            runTask(1, fileLines);
        }

        try {
            fileLines = readFile(task2_path);
        } catch (IOException e) {
            System.err.println("Can't open file " + task2_path);
        }
        if (fileLines != null) {
            runTask(2, fileLines);
        }
    }
}
