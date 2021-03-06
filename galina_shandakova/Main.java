import tasks.*;

import java.util.List;

import static utils.FileUtils.*;

public class Main {
    public static void main(String[] args) {
        try {
            countDNANucleotides();
            transcribeDNAintoRNA();
            complementStrandOfDNA();
            countNumRabbits();
            countNumMortalRabbits();
            computeGcContent();
            findMotif();
            overlapGraphs();
            locatingRestrictionSites();
            mendelFirstLaw();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private static void countDNANucleotides() {
        System.out.println("Task 1: Counting DNA Nucleotides.");
        CountingDnaNucleotides.countFromString(
                readStringFromFile("galina_shandakova/resources/rosalind_dna.txt"));
        printSeparator();
    }

    private static void transcribeDNAintoRNA() {
        System.out.println("Task 2: Transcribing DNA into RNA.");
        System.out.println(TranscribingDnaIntoRna.translateIntoRna(
                readStringFromFile("galina_shandakova/resources/rosalind_rna.txt")));
        printSeparator();
    }

    private static void complementStrandOfDNA() {
        System.out.println("Task 3: Complementing a Strand of DNA.");
        System.out.println(ComplementingStrandOfDna.compute(
                readStringFromFile("galina_shandakova/resources/rosalind_revc.txt")));
        printSeparator();
    }

    private static void countNumRabbits() {
        System.out.println("Task 4: Rabbits and Recurrence Relations.");
        List<Integer> monthAndFertility =
                readIntegersInOneLine("galina_shandakova/resources/rosalind_fib.txt", 2);
        if (monthAndFertility.size() == 2) {
            System.out.println(
                    RabbitsAndRecurrenceRelations.countTotalNumberBySimulation(monthAndFertility.get(0),
                            monthAndFertility.get(1)));
        }
        printSeparator();
    }

    private static void countNumMortalRabbits() {
        System.out.println("Task 5: Mortal Fibonacci Rabbits.");
        List<Integer> monthAndDieMonth =
                readIntegersInOneLine("galina_shandakova/resources/rosalind_fibd.txt", 2);
        if (monthAndDieMonth.size() == 2) {
            System.out.println(
                    MortalFibonacciRabbits.countBySimulation(monthAndDieMonth.get(0), monthAndDieMonth.get(1)));
        }
        printSeparator();
    }

    private static void computeGcContent() {
        System.out.println("Task 6: Computing GC Content.");
        System.out.println(ComputingGcContent.findHighestGcContent(
                readDnaAndNamesFromFastaFormatFile("galina_shandakova/resources/rosalind_gc.txt")));
        printSeparator();
    }

    private static void findMotif() {
        System.out.println("Task 7: Finding a Motif in DNA.");
        List<String> lines = readLinesFromFile("galina_shandakova/resources/rosalind_subs.txt",
                2);
        List<Integer> positions = FindingMotifInDna.findMotif(lines.get(0), lines.get(1));
        positions.forEach(position -> System.out.print(position + " "));
        System.out.println("\n");
        printSeparator();
    }

    private static void overlapGraphs() {
        System.out.println("Task 8: Overlap Graphs.");
        List<String> adjacencyList = OverlapGraphs.getAdjacencyList(
                readDnaAndNamesFromFastaFormatFile("galina_shandakova/resources/rosalind_grph.txt"));
        adjacencyList.forEach(System.out::println);
        printSeparator();
    }

    private static void locatingRestrictionSites() {
        System.out.println("Task 9: Locating Restriction Sites.");
        List<String> palindromes = LocatingRestrictionSites.findReversePalindrome(
                readDnaAndNamesFromFastaFormatFile("galina_shandakova/resources/rosalind_revp.txt")
                        .values().stream().findFirst().orElse(""));
        palindromes.forEach(System.out::println);
        printSeparator();
    }

    private static void mendelFirstLaw() {
        System.out.println("Task 10: Mendel's First Law.");
        List<Integer> population =
                readIntegersInOneLine("galina_shandakova/resources/rosalind_iprb.txt", 3);
        if (population.size() == 3) {
            System.out.println(MendelFirstLaw.getProbability(population.get(0), population.get(1), population.get(2)));
        }
    }

    private static void printSeparator() {
        System.out.println("-----------------------------------");
    }
}
