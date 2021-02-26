import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task8 {

    public static Map<String, String> readFastaFile(final String fastaFilename) {
        Map<String, String> dnaStrings = new HashMap<>(); // <id, data>
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(new FileInputStream(fastaFilename)))) {
            String line;
            boolean first = true;
            String dnaStringId = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                //need to store this until all data for id is read
                if (line.charAt(0) == '>') {
                    String[] lineMetadata = line.split(" ");
                    // we can either compare stringBuilder with "" each time or introduce a flag.
                    if (first) {
                        first = false;
                        dnaStringId = lineMetadata[0].substring(1);
                        continue;
                    }
                    dnaStrings.put(dnaStringId, stringBuilder.toString());
                    stringBuilder.setLength(0);
                    // the first element looks like ">abc", so we only need a substring
                    dnaStringId = lineMetadata[0].substring(1);
                } else {
                    stringBuilder.append(line);
                }
            }
            dnaStrings.put(dnaStringId, stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dnaStrings;
    }

    public static void printHighestGCContentDNAString(final String filename) {
        Map<String, String> dnaStrings = readFastaFile(filename);
        Map<String, Double> gcValues = dnaStrings.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        dnaData -> evalGCContent(dnaData.getValue())
                ));
        Map.Entry<String, Double> highestGCValueEntry = gcValues.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new);
        System.out.printf("the highest gc value is %.6f for id %s",
                highestGCValueEntry.getValue(), highestGCValueEntry.getKey());

    }

    public static double evalGCContent(final String dnaString) {
        long gcAmount = Stream.of(dnaString.split(""))
                .filter(nucl -> nucl.equals("G") || nucl.equals("C"))
                .count();
        return (double) gcAmount * 100 / dnaString.length();
    }

}
