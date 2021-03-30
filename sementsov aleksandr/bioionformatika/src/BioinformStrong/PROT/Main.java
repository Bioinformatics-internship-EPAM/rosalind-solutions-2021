package BioinformStrong.PROT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    final static String pathPROTTask = "rosalind_prot.txt";
    final static String outputPath = "submission.txt";
    
    static String getDataSet(String stringWay) throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            return scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        final String stopProtein = "Stop";

        StringBuilder currentData = null;
        FileWriter writer;

        try {

            // Loading protein table.
            RNACodonTable rnaCodonTable = new RNACodonTable();
            try {

                // Dataset set
                currentData = new StringBuilder(getDataSet(pathPROTTask));
                try {

                    // Prepare to write
                    writer = new FileWriter(outputPath, StandardCharsets.UTF_8);
                    String result;
                    for (int dataIndex = 0; dataIndex < (currentData != null ? currentData.length() : 0);) {
                        try {

                            // Find target item from protein table.
                            result = rnaCodonTable.codonList.get(currentData.substring(dataIndex, dataIndex + 3));
                            if (result.equals(stopProtein)) {
                                result = "";
                            }
                            dataIndex += 3;
                        }
                        catch (NullPointerException e) {
                            result = currentData.substring(dataIndex, dataIndex);
                            dataIndex += 1;
                        }
                        writer.write(result);
                    }
                    writer.close();
                    System.out.println("Dataset is loaded");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nProtein table not found (look up).");
        }
    }
}
