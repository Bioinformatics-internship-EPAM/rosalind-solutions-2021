import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task9 {

    public static Map<String, String> proteinAbbreviations;
    static {
        proteinAbbreviations = new HashMap<>();
        proteinAbbreviations.put("UUU", "F");
        proteinAbbreviations.put("UUC", "F");
        proteinAbbreviations.put("UUA", "L");
        proteinAbbreviations.put("UUG", "L");
        proteinAbbreviations.put("UCU", "S");
        proteinAbbreviations.put("UCC", "S");
        proteinAbbreviations.put("UCA", "S");
        proteinAbbreviations.put("UCG", "S");
        proteinAbbreviations.put("UAU", "Y");
        proteinAbbreviations.put("UAC", "Y");
        proteinAbbreviations.put("UAA", "");
        proteinAbbreviations.put("UAG", "");
        proteinAbbreviations.put("UGU", "C");
        proteinAbbreviations.put("UGC", "C");
        proteinAbbreviations.put("UGA", "");
        proteinAbbreviations.put("UGG", "W");
        proteinAbbreviations.put("CUU", "L");
        proteinAbbreviations.put("CUC", "L");
        proteinAbbreviations.put("CUA", "L");
        proteinAbbreviations.put("CUG", "L");
        proteinAbbreviations.put("CCU", "P");
        proteinAbbreviations.put("CCC", "P");
        proteinAbbreviations.put("CCA", "P");
        proteinAbbreviations.put("CCG", "P");
        proteinAbbreviations.put("CAU", "H");
        proteinAbbreviations.put("CAC", "H");
        proteinAbbreviations.put("CAA", "Q");
        proteinAbbreviations.put("CAG", "Q");
        proteinAbbreviations.put("CGU", "R");
        proteinAbbreviations.put("CGC", "R");
        proteinAbbreviations.put("CGA", "R");
        proteinAbbreviations.put("CGG", "R");
        proteinAbbreviations.put("AUU", "I");
        proteinAbbreviations.put("AUC", "I");
        proteinAbbreviations.put("AUA", "I");
        proteinAbbreviations.put("AUG", "M");
        proteinAbbreviations.put("ACU", "T");
        proteinAbbreviations.put("ACC", "T");
        proteinAbbreviations.put("ACA", "T");
        proteinAbbreviations.put("ACG", "T");
        proteinAbbreviations.put("AAU", "N");
        proteinAbbreviations.put("AAC", "N");
        proteinAbbreviations.put("AAA", "K");
        proteinAbbreviations.put("AAG", "K");
        proteinAbbreviations.put("AGU", "S");
        proteinAbbreviations.put("AGC", "S");
        proteinAbbreviations.put("AGA", "R");
        proteinAbbreviations.put("AGG", "R");
        proteinAbbreviations.put("GUU", "V");
        proteinAbbreviations.put("GUC", "V");
        proteinAbbreviations.put("GUA", "V");
        proteinAbbreviations.put("GUG", "V");
        proteinAbbreviations.put("GCU", "A");
        proteinAbbreviations.put("GCC", "A");
        proteinAbbreviations.put("GCA", "A");
        proteinAbbreviations.put("GCG", "A");
        proteinAbbreviations.put("GAU", "D");
        proteinAbbreviations.put("GAC", "D");
        proteinAbbreviations.put("GAA", "E");
        proteinAbbreviations.put("GAG", "E");
        proteinAbbreviations.put("GGU", "G");
        proteinAbbreviations.put("GGC", "G");
        proteinAbbreviations.put("GGA", "G");
        proteinAbbreviations.put("GGG", "G");
    }
    public static Map<String, String> readFastaFile(final String fastaFilename) {
        //unlike earlier task we do need the ordering guarantees, hence the linkedHashMap
        Map<String, String> dnaStrings = new LinkedHashMap<>(); // <id, data>
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
    public static String createProteinString(final String filename) {
        Map<String, String> fileData = readFastaFile(filename);
        final Map.Entry<String, String> dnaSequenceEntry = fileData.entrySet().iterator().next();
        fileData.remove(dnaSequenceEntry.getKey());

        // we exclude the dna string itself. to only erase introns.
        fileData.entrySet().stream()
                .forEach(intron -> dnaSequenceEntry.setValue(dnaSequenceEntry.getValue().replaceAll(intron.getValue(),"")));

        final String rnaSequence = getTranscribedRna(dnaSequenceEntry.getValue());
        return IntStream
                .iterate(0, i -> i + 3)
                .limit((int) Math.ceil(rnaSequence.length() / 3.0))
                .mapToObj(i -> rnaSequence.substring(i, i+3))
                .map(nuclTriplet -> proteinAbbreviations.get(nuclTriplet))
                .collect(Collectors.joining());
    }

    public static String getTranscribedRna(final String dnaString) {
        return Stream.of(dnaString.split(""))
                .map(nucl -> {
                    if (nucl.equals("T")) {
                        return "U";
                    }
                    return nucl;
                })
                .collect(Collectors.joining());
    }
}
