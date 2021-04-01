package BioinformStrong.PROT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class RNACodonTable {

    final String codonTableFile = "RNA-codon-table.txt";

    /** RNA codon table in Map-format */
    Map<String, String> codonList;

    /** This constructor generate RNA codon table from text-file */
    RNACodonTable() throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(codonTableFile, StandardCharsets.UTF_8))) {
            codonList = new TreeMap<>();
            Scanner scanner = new Scanner(brReader);
            String readString;
            String[] elementsInString;
            String[] currentSequence = new String[2];
            int elementIndex = 0;

            // working with file
            while (true) {

                // if line is exists, program continue
                try {
                    readString = scanner.nextLine();
                    elementsInString = readString.split("\s+"); // fix space (\s), having length not less 1 symbol (+)

                    // occur pair from ejected line
                    for (String s : elementsInString) {
                        currentSequence[elementIndex % 2] = s;

                        // if pair whole processing, put this pair on map
                        if (elementIndex % 2 == 1) {
                            codonList.put(currentSequence[0], currentSequence[1]);
                        }
                        elementIndex++;
                    }
                }
                catch (NoSuchElementException e) {
                    break;
                }
            }
        }
    }

    public String getProteinItem(String keyForProteinItem) {
        return codonList.get(keyForProteinItem);
    }
}
