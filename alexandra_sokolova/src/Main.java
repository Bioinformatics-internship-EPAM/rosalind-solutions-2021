import tasks.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Counting DNA Nucleotides:");
        CountingDNANucleotides.countNucleotides("src/resources/rosalind_dna.txt");

        System.out.println("Transcribing DNA into RNA:");
        TranscribingDNAintoRNA.transcribeDNA("src/resources/rosalind_rna.txt");

        System.out.println("Complementing a Strand of DNA:");
        ComplementingaStrandofDNA.complementDNA("src/resources/rosalind_revc.txt");

        System.out.println("Counting Point Mutations:");
        CountingPointMutations.countMutations("src/resources/rosalind_hamm.txt");

        System.out.println("Finding a Motif in DNA:");
        FindingaMotifinDNA.findMotif("src/resources/rosalind_subs.txt");

        System.out.println("Translating RNA into Protein:");
        TranslatingRNAintoProtein.translateRNA("src/resources/rosalind_prot.txt");

        System.out.println("Calculating Protein Mass:");
        CalculatingProteinMass.calculateMass("src/resources/rosalind_prtm.txt");

        System.out.println("Calculating Rabbit Pairs:");
        RabbitsandRecurrenceRelations.calculateRabbitPairs("src/resources/rosalind_fib.txt");

        System.out.println("Mortal Fibonacci Rabbits:");
        MortalFibonacciRabbits.calculateRabbitPairs("src/resources/rosalind_fibd.txt");

        System.out.println("Mendel's First Law:");
        MendelsFirstLaw.calculateProbability ("src/resources/rosalind_iprb.txt");
    }
}
