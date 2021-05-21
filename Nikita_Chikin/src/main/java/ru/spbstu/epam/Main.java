package ru.spbstu.epam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static Map<String, String> readTable(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        Map<String, String> table = new HashMap<>();
        for (String line : lines) {
            String[] str = line.replaceAll("\\s+", " ").split(" ");
            for (int i = 0; i < str.length - 1; i += 2) {
                int nextElem = i + 1;
                table.put(str[i], str[nextElem]);
            }
        }
        return table;
    }

    private static String openFrame(String str) {
        int start = str.indexOf("ATG");
        int i = start + 3;
        while (i < str.length() - 3 && start != -1) {
            String endStr = str.substring(i, i + 3);
            if (endStr.equals("TAG") || endStr.equals("TGA") || endStr.equals("TAA")) {
                return str.substring(start, i + 3);
            }
            i += 3;
        }
        return "";
    }

    public static String createRnaFromDna(String t) {
        StringBuilder stringBuffer = new StringBuilder(t);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == 'T') {
                stringBuffer.setCharAt(i, 'U');
            }
        }
        return stringBuffer.toString();
    }

    public static String createProtein(String str) {
        Map<String, String> table = null;
        try {
            table = readTable("resources/RNAProteinTable.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length() - 3; i += 3) {
            int end = i + 3;
            String codon = str.substring(i, end).trim();
            String protein = table.get(codon);
            if (protein.equals("Stop")) {
                result.append("\n");
            }
            result.append(protein);
        }
        return result.toString();
    }

    public static double calcMass(String str) {
        Map<String, String> table = null;
        try {
            table = readTable("resources/massTable.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        double res = 0;
        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));
            res += Double.parseDouble(table.get(ch));
        }
        return res;
    }

    public static String complementingDNA(String str) {
        StringBuffer rts = (new StringBuffer(str)).reverse();
        int i = 0;
        while (i < rts.length()) {
            switch (rts.charAt(i)) {
                case 'A' -> rts.setCharAt(i, 'T');
                case 'T' -> rts.setCharAt(i, 'A');
                case 'C' -> rts.setCharAt(i, 'G');
                default -> rts.setCharAt(i, 'C');
            }
            i++;
        }
        return rts.toString();
    }

    public static List<String> searchProtein(String str) {
        List<String> res = new ArrayList<>();
        searcherProtein(str, res);
        str = complementingDNA(str);
        searcherProtein(str, res);
        return res;
    }

    private static void searcherProtein(String str, List<String> res) {
        int i = 0;
        while (i < str.length() - 6) {
            String dna = openFrame(str.substring(i));
            if (dna.equals("")) {
                break;
            }
            i += str.substring(i).indexOf("ATG") + 3;
            String s = createProtein(createRnaFromDna(dna));
            if (!res.contains(s)) {
                res.add(s);
                double mass = calcMass(s);
                res.add(String.valueOf(mass));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("resources/genome.fasta");
        Scanner scanner = new Scanner(fileReader);
        scanner.nextLine();
        StringBuilder str = new StringBuilder();
        while (scanner.hasNext()) {
            str.append(scanner.nextLine());
        }
        fileReader.close();
        List<String> res = searchProtein(str.toString());
        FileWriter fileWriter = new FileWriter("resources/genome.output");
        for (String s : res) {
            fileWriter.write(s + "\n");
        }
        fileWriter.close();
    }
}
