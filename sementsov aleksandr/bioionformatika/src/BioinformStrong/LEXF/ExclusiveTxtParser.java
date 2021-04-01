package BioinformStrong.LEXF;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

/** Special parser for parsing LEXF-task */
public class ExclusiveTxtParser {

    String parsedAlphabet;
    int parsedNumber;

    /** this key word, which make unique name of this task */
    final String keyWordDatasetPath = "LEXF";

    String findDataSet() throws FileNotFoundException {
        String directory = System.getProperty("user.dir");
        String[] files = new File(directory).list();
        String res = "";
        for (String file : Objects.requireNonNull(files)) {
            if (file.contains(this.keyWordDatasetPath.toLowerCase())) {
                res = file;
                break;
            }
        }
        return res;
    }

    void parseWidth(Scanner scanner) {
        parsedNumber = scanner.nextInt();
    }

    void parseAlphabet(Scanner scanner) {
        String ejectedAlphabet = scanner.nextLine();
        parsedAlphabet = ejectedAlphabet.replaceAll("\s", "");

        // next, call parser for width
        parseWidth(scanner);
    }

    /** start parse dataset */
    void parse(String stringWay) throws IOException {
        try (BufferedReader buffForRead = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(buffForRead);

            // first of all, call parser for alphabet
            parseAlphabet(scanner);

            // And at the end, close scanner
            scanner.close();
        }
    }

    /** Parser was initialized, while start parsing */
    public ExclusiveTxtParser() {
        try {
            String pathDataset = findDataSet();
            try {
                parse(pathDataset);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        catch (FileNotFoundException fNull) {
            fNull.printStackTrace();
        }
    }

    public String getAlphabet() {
        return parsedAlphabet;
    }

    public int getWidth() {
        return parsedNumber;
    }
}
