package BioinformStrong.LEXF;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

public class ExclusiveTxtParser {

    static String parsedAlphabet;
    static int parsedNumber;
    final static String keyWordDatasetPath = "LEXF";

    static String findDataSet() throws FileNotFoundException {
        String directory = System.getProperty("user.dir");
        String[] files = new File(directory).list();
        String res = "";
        for (String file : Objects.requireNonNull(files)) {
            if (file.contains(ExclusiveTxtParser.keyWordDatasetPath.toLowerCase())) {
                res = file;
                break;
            }
        }
        return res;
    }

    static String parseAlphabet(Scanner scanner) {
        String ejectedAlphabet = scanner.nextLine();
        return ejectedAlphabet.replaceAll("\s", "");
    }

    static int parseWidth(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void parse(String stringWay) throws IOException {
        try (BufferedReader buffForRead = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(buffForRead);
            parsedAlphabet = parseAlphabet(scanner);
            parsedNumber = parseWidth(scanner);
        }
    }

    public static void goParse() {
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

    public static String getAlphabet() {
        return parsedAlphabet;
    }

    public static int getWidth() {
        return parsedNumber;
    }
}
