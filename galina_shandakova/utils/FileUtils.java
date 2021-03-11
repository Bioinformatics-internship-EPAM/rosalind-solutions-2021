package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
    private FileUtils() {
    }

    public static String readStringFromFile(String fileName) throws RuntimeException {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Аn error occurred while reading the file.", e);
        }
        return line;
    }

    public static Map<String, String> readDnaAndNamesFromFastaFormatFile(String fileName) throws RuntimeException {
        Map<String, String> dnaWithNames = new LinkedHashMap<>();
        String name = null;
        StringBuilder dna = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith(">")) {
                    if (name != null) {
                        dnaWithNames.put(name, dna.toString());
                    }
                    name = line.substring(1);
                    dna = new StringBuilder();
                } else {
                    dna.append(line);
                }
            }
            dnaWithNames.put(name, dna.toString());
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the Fasta file.", e);
        }
        return dnaWithNames;
    }

    public static List<String> readLinesFromFile(String fileName, int expectedNumOfLines) throws RuntimeException {
        List<String> lines;
        try (Stream<String> linesStream = Files.lines(Paths.get(fileName))) {
            lines = linesStream.limit(expectedNumOfLines).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the Fasta file.", e);
        }
        if (lines.size() != expectedNumOfLines) {
            throw new RuntimeException("The requested number of lines does not match the found.");
        }
        return lines;
    }

    public static List<Integer> readIntegersInOneLine(String fileName, int expectedNumberOfInt)
            throws RuntimeException {
        String[] numbers = readStringFromFile(fileName).split(" ");
        List<Integer> collect;
        try {
            collect = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("The presented values are not integers.", e);
        }
        if (collect.size() != expectedNumberOfInt) {
            throw new RuntimeException("The file does not contain " + expectedNumberOfInt + " integers ");
        }
        return collect;
    }
}
