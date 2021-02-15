import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readFromFile(String fileName) throws Exception {
        var fullPath = Paths.get(FileUtils.class.getResource(fileName).getPath().substring(1));
        return Files.readAllLines(fullPath);
    }

    public static List<FastaEntry> readFromFastaFile(String fileName) throws Exception {
        var lines = readFromFile(fileName);
        var list = new ArrayList<FastaEntry>();

        FastaEntry fastaEntry = null;
        int i = 0;
        while (i < lines.size()) {
            if (lines.get(i).charAt(0) == '>') {
                fastaEntry = new FastaEntry();
                fastaEntry.setId(lines.get(i).substring(1));
                i++;
            } else {
                var sb = new StringBuilder();
                while (i < lines.size() && lines.get(i).charAt(0) != '>') {
                    sb.append(lines.get(i));
                    i++;
                }

                fastaEntry.setDescription(sb.toString());
                list.add(fastaEntry);
            }
        }

        return list;
    }
}
