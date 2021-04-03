package BioinformStrong.SUBS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/** Special parser for parsing SUBS-task */
public class ParserForSUBS {
    final String defaultDatasetName = "rosalind_subs";
    String parsedSource;
    String parsedMatch;

    void parse(String filename) throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);

            // Order of parsing on your own
            parsedSource = scanner.nextLine();
            parsedMatch = scanner.nextLine();

            // And at the end, close scanner
            scanner.close();
        }
    }

    ParserForSUBS(String pathName) {
        try {
            parse(pathName + ".txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSource() {
        if (parsedSource != null && !parsedSource.equals("")) {
            return parsedSource;
        }
        else {
            try {
                parse(defaultDatasetName);
            }
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("\n\n\t->\tDataset is out (look up).");
            }
            System.out.println("Dataset wasn't parsed. Please repeat the request.");
            return "";
        }
    }

    public String getMatch() {
        if (parsedMatch != null && !parsedMatch.equals("")) {
            return parsedMatch;
        }
        else {
            try {
                parse(defaultDatasetName);
            }
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("\n\n\t->\tDataset is out (look up).");
            }
            System.out.println("Dataset wasn't parsed. Please repeat the request.");
            return "";
        }
    }
}
