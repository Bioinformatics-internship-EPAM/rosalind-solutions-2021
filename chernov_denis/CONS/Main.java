package CONS;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    static final Character[] NUKLEOTIDES = {'A', 'C', 'G', 'T'};
    public static Map<String, String> readFASTA(String path) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        StringBuilder builder = new StringBuilder();
        String label = "";
        for (String line: lines){
            if (line.charAt(0)  == '>') {
                if (builder.length() != 0) {
                    map.put(label, builder.toString());
                    builder.setLength(0);
                }
                label = line.substring(1);
            } else {
                builder.append(line);
            }
        }
        if (builder.length() != 0) {
            map.put(label, builder.toString());
            builder.setLength(0);
        }
        return map;
    }
    public static void printResultDNA(int[][] matrix){
        int indexOfMax = 0;
        for (int[] array: matrix) {
            for (int i = 0; i < NUKLEOTIDES.length; i ++){
                if (array[i] > array[indexOfMax])
                {
                    indexOfMax = i;
                }
            }
            System.out.print(NUKLEOTIDES[indexOfMax]);
        }
        System.out.println();
    }
    public static void printDNAMatrix(int[][] matrix){
        for (int i = 0; i < NUKLEOTIDES.length; i ++){
            System.out.printf("%c: ", NUKLEOTIDES[i]);
            for (int[] ints : matrix) {
                System.out.printf("%d ", ints[i]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        Collection<String> sequences = readFASTA("src/CONS/rosalind_cons.txt").values();
        int sequenceLength = sequences.iterator().next().length();
        int[][] matrix = new int[sequenceLength][NUKLEOTIDES.length];
        List<Character> nukleotidesList = Arrays.asList(NUKLEOTIDES);
        for (String dna: sequences) {
            for (int i = 0; i < dna.length(); i++){
                matrix[i][nukleotidesList.indexOf(dna.charAt(i))]++;
            }
        }
        printResultDNA(matrix);
        printDNAMatrix(matrix);
    }
}