package BioinformStrong.HAMM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    final static String pathHAMMTask = "rosalind_HAMM.txt";

    static String[] getDataSet() throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(Main.pathHAMMTask.toLowerCase(), StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            String[] s = new String[2];
            s[0] = scanner.nextLine();
            s[1] = scanner.nextLine();
            return s;
        }
    }

    public static void main(String[] args) {

        //To load a dataset
        String[] dataSet = null;
        try {
            dataSet = getDataSet();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //To init frequency of differ
        int freq = 0;

        //To realize the algorithm
        for(int i = 0; i < (dataSet != null ? dataSet[0].length() : 0); i++) {
            if (dataSet[0].charAt(i) != dataSet[1].charAt(i)) {
                freq++;
            }
        }

        //To set dataset-result
        System.out.print(freq);
    }
}
