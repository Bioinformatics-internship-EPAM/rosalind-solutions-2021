package ru.spbstu.shakhmin.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class RosalindUtils {

    public static final Map<Character, Character> DNA_COMPLEMENTS = Map.of(
            'A', 'T',
            'T', 'A',
            'C', 'G',
            'G', 'C');

    private static final String FASTA_LABEL = ">";

    private RosalindUtils() {
        // not instantiable
    }

    public static List<String> loadDataset(final String fileName) throws URISyntaxException, IOException {
        final var pathToDataset = Paths.get(
                Objects.requireNonNull(RosalindUtils.class.getClassLoader().getResource(fileName)).toURI());
        return Files.readAllLines(pathToDataset);
    }

    public static Iterable<FastaBlock> fastaBlocks(final List<String> dataset) {
        return () -> new FastaIterator(dataset);
    }

    private static final class FastaIterator implements Iterator<FastaBlock> {
        private final Iterator<String> dataset;
        private String currentLine;

        private FastaIterator(final List<String> dataset) {
            this.dataset = dataset.iterator();
            this.currentLine = this.dataset.next();
        }

        @Override
        public boolean hasNext() {
            return dataset.hasNext();
        }

        @Override
        public FastaBlock next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            final var id = currentLine.substring(1);
            final var description = new StringBuilder();
            currentLine = dataset.next();
            while (hasNext() && !(currentLine).startsWith(FASTA_LABEL)) {
                description.append(currentLine);
                currentLine = dataset.next();
            }
            if (!hasNext()) {
                description.append(currentLine);
            }
            return new FastaBlock(id, description.toString());
        }
    }
}
