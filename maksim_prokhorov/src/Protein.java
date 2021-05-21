import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Protein {

    static void searchForProteinInDNA(String dnaString) {
        Set<String> proteins = Tasks.openReadingFrames(dnaString);
        IO.writeToFile("maksim_prokhorov/genome_results/proteins.txt", proteins);
    }

    static void calculateProteinMass(String dataset) {
        Set<String> proteins = Tasks.openReadingFrames(dataset);
        List<String> result = new ArrayList<>();
        for (String str : proteins) {
            result.add(str);
            result.add(Tasks.calculatingProteinMass(str));
        }
        IO.writeToFile("maksim_prokhorov/genome_results/proteins_mass.txt", result);
    }
}
