package CONS;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static HashMap<String, String> ReadFASTA(String path) throws IOException {
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
    public static void PrintResultDNA(int[][] matrix){
        int indexOfMax = 0;
        for (int[] array: matrix) {
            for (int i = 0; i < 4; i ++){
                if (array[i] > array[indexOfMax])
                {
                    indexOfMax = i;
                }
            }
            switch (indexOfMax) {
                case 0 -> System.out.print('A');
                case 1 -> System.out.print('C');
                case 2 -> System.out.print('G');
                case 3 -> System.out.print('T');
            }
        }
        System.out.println();
    }
    public static void PrintDNAMatrix(int[][] matrix){
        char[] nuk = {'A', 'C', 'G', 'T'};
        for (int i = 0; i < 4; i ++){
            System.out.printf("%c: ", nuk[i]);
            for (int[] ints : matrix) {
                System.out.printf("%d ", ints[i]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = ReadFASTA("src/CONS/rosalind_cons.txt");
        int[][] matrix = new int[map.values().iterator().next().length()][4];
        Iterator<String> iter = map.values().iterator();
        String dna;
        while (iter.hasNext()){
            dna = iter.next();
            for (int i = 0; i < dna.length(); i++){
                switch (dna.charAt(i)){
                    case 'A' -> matrix[i][0]++;
                    case 'C' -> matrix[i][1]++;
                    case 'G' -> matrix[i][2]++;
                    case 'T' -> matrix[i][3]++;
                }
            }
        }
        PrintResultDNA(matrix);
        PrintDNAMatrix(matrix);
    }
}