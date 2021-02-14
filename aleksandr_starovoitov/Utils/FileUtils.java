import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    public static List<String> readFromFile(String fileName) throws Exception {
        var fullPath = Paths.get(FileUtils.class.getResource(fileName).getPath().substring(1));
        return Files.readAllLines(fullPath);
    }
}
