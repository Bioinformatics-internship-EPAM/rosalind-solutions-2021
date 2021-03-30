package BioinformStrong.SUBS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ParserForSUBS {
    final String defaultDatasetName = "rosalind_subs";
    String parsedSource;
    String parsedMatch;

    void parse(String filename) throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            parsedSource = scanner.nextLine();
            parsedMatch = scanner.nextLine();
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
                System.out.println("\n\n\t\t->\t\tDataset is out (см. выше).");
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
                System.out.println("\n\n\t\t->\t\tDataset is out (см. выше).");
            }
            System.out.println("Dataset wasn't parsed. Please repeat the request.");
            return "";
        }
    }
}
