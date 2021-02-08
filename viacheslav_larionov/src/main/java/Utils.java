import java.io.*;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.IntStream;

public class Utils {

    public static List<String> readDNAStringsFromFile(final String filename) {
        ClassLoader classLoader = Utils.class.getClassLoader();
        List<String> dnas = new LinkedList<>();

        try (InputStream rd = classLoader.getResourceAsStream(filename);
             InputStreamReader inp = new InputStreamReader(Objects.requireNonNull(rd));
             BufferedReader reader = new BufferedReader(inp)) {
            String line;
            while ((line = reader.readLine()) != null) {
                dnas.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dnas;
    }

    public static LinkedHashMap<String, String> getFastaRecords(final String filename) {
        ClassLoader classLoader = Utils.class.getClassLoader();
        LinkedHashMap<String, String> fastaRecordsMap = new LinkedHashMap<>();

        try (InputStream rd = classLoader.getResourceAsStream(filename);
             InputStreamReader inp = new InputStreamReader(Objects.requireNonNull(rd));
             BufferedReader reader = new BufferedReader(inp)) {
            String line;
            boolean hasFASTAFormatRecord = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(">")) {
                    hasFASTAFormatRecord = true;
                    break;
                }
            }

            if (hasFASTAFormatRecord) {
                String oldKey = line;
                StringBuilder builder = new StringBuilder();

                // Add records from first to pre last
                while ((line = reader.readLine()) != null && !line.equals("")) {
                    if (line.charAt(0) == '>') {
                        if (!builder.toString().equals("")) {
                            fastaRecordsMap.put(oldKey.replace(">", ""), builder.toString());
                            builder.setLength(0);
                        } else {
                            throw new InvalidParameterException("No value for FASTA record");
                        }

                        oldKey = line;
                    } else {
                        builder.append(line);
                    }
                }

                // Add last FASTA record
                if (!builder.toString().equals("")) {
                    fastaRecordsMap.put(oldKey.replace(">", ""), builder.toString());
                } else {
                    throw new InvalidParameterException("No value for FASTA record");
                }
            } else {
                throw new Exception("No FASTA records in file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fastaRecordsMap;
    }

    public static List<String> getLinesFromFile(final String filename) {
        List<String> lines = new LinkedList<>();
        ClassLoader classLoader = Utils.class.getClassLoader();

        try (InputStream rd = classLoader.getResourceAsStream(filename);
             InputStreamReader inp = new InputStreamReader(Objects.requireNonNull(rd));
             BufferedReader reader = new BufferedReader(inp)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static Properties getProperties(final String filename) {
        Properties prop = new Properties();
        ClassLoader loader = Utils.class.getClassLoader();

        try (InputStream stream =
                     loader.getResourceAsStream(filename)) {
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    public static long hammingDistance(final String DNA1, final String DNA2) {
        return IntStream.range(0, DNA1.length())
                .filter(i -> DNA1.charAt(i) != DNA2.charAt(i))
                .count();
    }
}
