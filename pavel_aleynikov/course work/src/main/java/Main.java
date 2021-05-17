import dto.Protein;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import task.CalculatingProteinMass;
import task.ComparingProtein;
import task.DNAIntoRNATranscribing;
import task.RNAIntoProteinTranslator;
import utils.fasta.FASTAItem;
import utils.fasta.FASTAReader;
import utils.fasta.FASTAWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final DecimalFormat PROTEIN_MASS_FORMAT = new DecimalFormat("#.###");

    private static final String ANALYZED_DNA_FILE = "SARS-CoV-2.fasta";
    private static final String DEFINED_PROTEINS_FILE = "exist_proteins.fasta";
    private static final String OUTPUT_FILE_NAME = "finded_proteins.fasta";

    public static void main(String[] args) throws URISyntaxException, IOException {
        String dna = FASTAReader.readAllFromFile(
                Paths.get(ClassLoader.getSystemResource(ANALYZED_DNA_FILE).toURI()))
                .get(0).getSequence();
        LOGGER.info("Read DNA with length: {}", dna.length());

        List<Protein> proteins = RNAIntoProteinTranslator.translate(
                DNAIntoRNATranscribing.transcribe(dna));
        LOGGER.info("Find {} proteins in original DNA", proteins.size());

        proteins = proteins.stream()
                .sorted(Comparator.comparingInt(Protein::getStartIndex))
                .collect(Collectors.toList());

        //write with location and mass
        writeProteins(OUTPUT_FILE_NAME, proteins);

        List<FASTAItem> definedProteins = FASTAReader.readAllFromFile(
                Paths.get(ClassLoader.getSystemResource(DEFINED_PROTEINS_FILE).toURI()));
        LOGGER.info("Read {} defined proteins", definedProteins.size());
        int matchedCount = ComparingProtein.analyze(
                ComparingProtein.convertFastsToProtein(definedProteins),
                proteins);
        LOGGER.info("Matched {} proteins. Can't find {} proteins", matchedCount, definedProteins.size() - matchedCount);
    }

    public static void writeProteins(String filename, List<Protein> proteins) throws IOException {
        List<FASTAItem> proteinsInFasts = new ArrayList<>(proteins.size());
        for (Protein protein : proteins) {
            StringBuilder labelBuilder = new StringBuilder();
            labelBuilder.append("location:");
            labelBuilder.append(protein.getStartIndex());
            labelBuilder.append("..");
            labelBuilder.append(protein.getStopIndex());
            labelBuilder.append("/mass:");
            labelBuilder.append(PROTEIN_MASS_FORMAT.format(CalculatingProteinMass.calculate(protein.getSequence())));
            proteinsInFasts.add(new FASTAItem(labelBuilder.toString(), protein.getSequence()));
        }
        FASTAWriter.writeAllToFile(Path.of(filename), proteinsInFasts);
    }

}
