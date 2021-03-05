package RosalindTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utils {
	public static List<String> readDataFromFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(Utils.class.getResource(fileName).getPath().substring(1)));
	}
}
