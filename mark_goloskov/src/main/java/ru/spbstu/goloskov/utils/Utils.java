package ru.spbstu.goloskov.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Utils {

    public static final String COUNTING_DNA_NUCL_FILE = "CountingDNANucleotides.txt";
    public static final String TRANSCRIBE_DNA_RNA = "TranscribingDNAintoRNA.txt";
    public static final String COMPLEMENT_STRAND_DNA = "ComplementingStrandOfDNA.txt";
    public static final String RABBITS_RECCURENCE_RELATIONS = "RabbitsRecurrenceRelations.txt";
    public static final String COUNTING_POINT_MUTATIONS = "CountingPointMutations.txt";
    public static final String FINDING_MOTIF_IN_DNA = "FindingMotifInDNA.txt";
    public static final String COMPUTING_GC_CONTENT = "ComputingGCContent.txt";
    public static final String TRANSLATING_RNA_PROTEIN = "TranslatingRNAProtein.txt";
    public static final String CALCULATING_PROTEIN_MASS = "CalculatingProteinMass.txt";
    public static final String LOCATING_RESTRICTION_SITES = "LocatingRestrictionSites.txt";

    public static final Map<Character, Character> COMPLEMENT_DNA = Map.of(
            'A', 'T',
            'T', 'A',
            'C', 'G',
            'G', 'C');

    private Utils() {

    }

    public static List<String> readFile(String fileName) throws URISyntaxException, IOException {
        URI uri = Objects.requireNonNull(Utils.class.getClassLoader().getResource(fileName)).toURI();
        return Files.readAllLines(Paths.get(uri));
    }

    public static String reverseComplement(String dna) {
        StringBuilder complementDNA = new StringBuilder();
        char symbol;
        for (int i = 0; i < dna.length(); i++) {
            symbol = dna.charAt(i);
            complementDNA.append(Utils.COMPLEMENT_DNA.get(symbol));
        }
        return complementDNA.reverse().toString();
    }

}
