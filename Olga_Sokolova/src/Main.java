import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<String> readFile(String path) {
        List<String> listOfLines = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            listOfLines = lines.collect(Collectors.toList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return listOfLines;
    }

    public static void main(String[] args) throws Exception {
        //1. Counting DNA Nucleotides http://rosalind.info/problems/dna/
        Solutions.getDNANucleotides(readFile("datasets/rosalind_dna.txt").get(0)).forEach(s -> System.out.printf("%s ", s));
        System.out.println();

        //2. Transcribing DNA into RNA http://rosalind.info/problems/rna/
        System.out.println(readFile("datasets/rosalind_rna.txt").get(0).replace('T', 'U'));

        //3. The Secondary and Tertiary Structures of DNA http://rosalind.info/problems/revc/
        System.out.println(String.join("", Solutions.getSecondaryAndTertiaryStructuresOfDNA(readFile("datasets/rosalind_revc.txt").get(0))));

        //4. Counting Point Mutations http://rosalind.info/problems/hamm/
        List<String> fileLines = readFile("datasets/rosalind_hamm.txt");
        String str1 = fileLines.get(0);
        String str2 = fileLines.get(1);
        System.out.println(Solutions.getHammingDistance(str1, str2));

        //5. Finding a Motif in DNA http://rosalind.info/problems/subs/
        fileLines = readFile("datasets/rosalind_subs.txt");
        String str0 = fileLines.get(0);
        String substr = fileLines.get(1);
        Solutions.findingMotifInDNA(str0, substr).forEach(s -> System.out.printf("%s ", s));
        System.out.println();

        //6. Translating RNA into Protein http://rosalind.info/problems/prot/
        Solutions.translatingRNAIntoProtein(readFile("datasets/rosalind_prot.txt").get(0)).forEach(s -> System.out.printf("%s", s));
        System.out.println();

        //7. Rabbits and Recurrence Relations http://rosalind.info/problems/fib/
        String[] params = readFile("datasets/rosalind_fib.txt").get(0).split(" ");
        System.out.println(Solutions.getRabbitsPopulationsSize(Integer.parseInt(params[0]), Integer.parseInt(params[1])));

        //8. Introduction to Mendelian Inheritance http://rosalind.info/problems/iprb/
        params = readFile("datasets/rosalind_iprb.txt").get(0).split(" ");
        int k = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int n = Integer.parseInt(params[2]);
        System.out.println(Solutions.getMendelProbability(k, m, n));

        //9. Calculating Expected Offspring http://rosalind.info/problems/iev/
        params = readFile("datasets/rosalind_iev.txt").get(0).split(" ");
        ArrayList<Integer> countOfCouples = new ArrayList<>();
        for (String param: params) {
            countOfCouples.add(Integer.parseInt(param));
        }
        System.out.printf("%f%n", Solutions.getCountOfDominantChildes(countOfCouples));

        //10. Calculating Protein Mass http://rosalind.info/problems/prtm/
        List<String> aa_array = Arrays.asList(readFile("datasets/rosalind_prtm.txt").get(0).split(""));
        System.out.println(Solutions.calculateProteinMass(aa_array));
    }
}
