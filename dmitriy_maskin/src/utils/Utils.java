package utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Utils {
    public static List<String> readFromFile(String filePath) throws Exception {
        Path fullPath = Paths.get(filePath);
        return Files.readAllLines(fullPath);
    }

}
