package BioinformStrong.PROT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    final static String stringWay = "rosalind_prot.txt";
    final static String outputPath = "output.txt";
    
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

        RNACodonTable rnaCodonTable = new RNACodonTable();

        try {
            currentData = new StringBuilder(getDataSet(stringWay));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer = new FileWriter(outputPath, StandardCharsets.UTF_8);
            String result;
            for (int dataIndex = 0; dataIndex < (currentData != null ? currentData.length() : 0);) {
                try {
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
}
