package ru.spbstu.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FastaFile {
    public static Map<String, String> readFileAndReturnDnaMap(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String lines = Files.lines(path).collect(Collectors.joining(" "));
        List<String> strings = Arrays.stream(lines.split(">")).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        Map<String, String> dnaMap = new LinkedHashMap<>();
        for (String string : strings) {
            List<String> stringList = new ArrayList<>();
            Collections.addAll(stringList, string.split(" "));
            String id = stringList.remove(0);;
            String dna = String.join("", stringList);
            dnaMap.put(id, dna);
        }
        return dnaMap;
    }
}
