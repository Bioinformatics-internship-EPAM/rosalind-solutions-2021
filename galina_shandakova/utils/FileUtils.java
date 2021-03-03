package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileUtils {
    private FileUtils() {
    }

    public static String readStringFromFile(String fileName) {
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            line = reader.readLine();
        } catch (IOException e) {
            System.err.println("Аn error occurred while reading the file.");
        }
        return line;
    }

    public static Map<String, String> readDnaAndNamesFromFastaFormatFile(String fileName) {
        Map<String, String> dnaWithNames = new LinkedHashMap<>();
        String name = null;
        StringBuilder dna = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith(">")) {
                    if (name != null) dnaWithNames.put(name, dna.toString());
                    name = line.substring(1);
                    dna = new StringBuilder();
                } else {
                    dna.append(line);
                }
            }
            dnaWithNames.put(name, dna.toString());
        } catch (IOException e) {
            System.err.println("Аn error occurred while reading the Fasta file.");
        }
        return dnaWithNames;
    }

    public static List<String> readLinesFromFile(String fileName, int expectedNumOfLines) {
        List<String> lines = new ArrayList<>(Collections.nCopies(expectedNumOfLines, ""));
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.set(counter, line);
                counter++;
                if (counter == expectedNumOfLines) break;
            }
        } catch (IOException e) {
            System.err.println("Аn error occurred while reading the Fasta file.");
        }
        if (counter != expectedNumOfLines) {
            System.err.println("The requested number of lines does not match the found.");
        }
        return lines;
    }

    public static List<Integer> readIntegersInOneLine(String fileName, int expectedNumberOfInt) {
        String[] numbers = readStringFromFile(fileName).split(" ");
        List<Integer> collect = null;
        try {
            collect = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
            if (collect.size() != expectedNumberOfInt) {
                System.err.println("The file does not contain " + expectedNumberOfInt + " integers ");
            }
        } catch (NumberFormatException e) {
            System.err.println("The presented values are not integers.");
        }
        return collect == null ? Collections.nCopies(expectedNumberOfInt, 0) : collect;
    }
}
