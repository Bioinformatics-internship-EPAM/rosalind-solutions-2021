import java.io.IOException;

public class Main {

    private final static String genomeFileName = "maksim_prokhorov/datasets/SARS-COV-2-genome.txt";

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.out.println(Tasks.printHelp());
            System.out.println("Use [p] in program args to find proteins in genome and [pm] to calculate proteins mass");
        } else if (args[0].equals("p")) {
            Protein.searchForProteinInDNA(
                    IO.getMultipleStringsInOne(genomeFileName)
            );
        } else if (args[0].equals("pm")) {
            Protein.calculateProteinMass((IO.getMultipleStringsInOne(genomeFileName)));
        } else {
            try {
                int taskNumber = Integer.parseInt(args[0]);
                System.out.println(Tasks.callFunction(taskNumber));
            } catch (IOException ex) {
                System.err.println("Cannot read dataset file.");
            }
        }
    }
}
