package GC;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static double CalculateCGcontent(List<String> sequence){
        double cgCount = 0;
        double squenceLength = 0;
        for (String line: sequence){
            squenceLength += line.length();
            cgCount += line.chars().filter(i -> i == 'C' || i == 'G').count();
        }
        return (cgCount / squenceLength) * 100;
    }
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/GC/rosalind_gc.txt"), StandardCharsets.UTF_8);
        List<String> oneSequence = new LinkedList<>();
        String label = "";
        String maxLabel = "";
        double maxCGcontent = 0;
        double cgContent;
        for (String line: lines){
            if (line.charAt(0)  == '>') {
                cgContent = CalculateCGcontent(oneSequence);
                if (cgContent > maxCGcontent) {
                    maxCGcontent = cgContent;
                    maxLabel = label;
                }
                oneSequence.clear();
                label = line.substring(1);
            } else {
                oneSequence.add(line);
            }
        }
        if (!oneSequence.isEmpty()) {
            cgContent = CalculateCGcontent(oneSequence);
            if (cgContent > maxCGcontent) {
                maxCGcontent = cgContent;
                maxLabel = label;
            }
        }
        System.out.println(maxLabel);
        System.out.println(maxCGcontent);
    }
}