package BioinformStrong.PROT;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    final static String pathPROTTask = "rosalind_prot.txt";
    final static String outputPath = "submission.txt";

    final static String stopProtein = "Stop";

    static RNACodonTable rnaCodonTable;

    static String findProteinItem(String currentData, int dataIndex) throws NullPointerException {
        String result;
        result = rnaCodonTable.getProteinItem(currentData.substring(dataIndex, dataIndex + 3));
        if (result.equals(stopProtein)) {
            result = "";
        }
        return result;
    }

    static void writeNewProteinSequence(String currentData) throws IOException {
        try (BufferedWriter brWriter = new BufferedWriter(new FileWriter(outputPath, StandardCharsets.UTF_8))) {
            String result;
            for (int dataIndex = 0; dataIndex < (currentData != null ? currentData.length() : 0); ) {
                try {
                    result = findProteinItem(currentData, dataIndex);
                    dataIndex += 3;
                } catch (NullPointerException e) {
                    result = currentData.substring(dataIndex, dataIndex);
                    dataIndex += 1;
                }
                brWriter.write(result);
            }
            brWriter.close();
            System.out.println("Dataset is loaded");
        }
    }
    
    static String getDataSet() throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(Main.pathPROTTask, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            return scanner.nextLine();
        }
    }

    public static void main(String[] args) {

        try {
            rnaCodonTable = new RNACodonTable();
            String currentData = getDataSet();
            writeNewProteinSequence(currentData);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
