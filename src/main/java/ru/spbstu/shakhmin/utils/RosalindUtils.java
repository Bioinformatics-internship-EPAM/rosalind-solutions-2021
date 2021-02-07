package ru.spbstu.shakhmin.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class RosalindUtils {

    public static final String FASTA_LABEL = ">";

    public static final Map<Character, Character> DNA_COMPLEMENTS = Map.of(
            'A', 'T',
            'T', 'A',
            'C', 'G',
            'G', 'C');

    private RosalindUtils() {
        // not instantiable
    }

    public static List<String> loadDataset(final String fileName) throws URISyntaxException, IOException {
        final var pathToDataset = Paths.get(
                Objects.requireNonNull(RosalindUtils.class.getClassLoader().getResource(fileName)).toURI());
        return Files.readAllLines(pathToDataset);
    }

    public enum DNASymbol {
        A, C, G, T
    }
}
