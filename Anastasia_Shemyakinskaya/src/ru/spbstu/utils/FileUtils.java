package ru.spbstu.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileUtils {
    public static Map<String, String> readFastaFileAndReturnDnaMap(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String lines = Files.lines(path).collect(Collectors.joining(" "));
        List<String> dnaChunks = Arrays.stream(lines.split(">")).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        Map<String, String> dnaMap = new LinkedHashMap<>();
        for (String string : dnaChunks) {
            List<String> chunkLines = new ArrayList<>();
            Collections.addAll(chunkLines, string.split(" "));
            String id = chunkLines.remove(0);
            ;
            String dna = String.join("", chunkLines);
            dnaMap.put(id, dna);
        }
        return dnaMap;
    }

    public static  Map<String, String> readTableAndReturnMap(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        Map<String, String> table = new HashMap<>();
        for (String str : lines) {
            String[] split = str.replaceAll("\\s+"," ").split(" ");
            for (int i = 0; i < split.length; i++) {
                int nextElem = i + 1;
                if (nextElem >= split.length) {
                    break;
                } else {
                    table.put(split[i], split[nextElem]);
                }
            }
        }
        return table;
    }
}
