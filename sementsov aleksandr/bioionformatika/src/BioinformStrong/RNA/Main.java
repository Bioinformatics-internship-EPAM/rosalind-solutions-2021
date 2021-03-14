package BioinformStrong.RNA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    
    static String getDataSet(String stringWay) throws IOException {
        String s;
        try (BufferedReader brReader = new BufferedReader(new FileReader(stringWay, StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);
            s = scanner.nextLine();
        }
        return s;
    }

    public static void main(String[] args) {

        //To load a dataset
        String s = "";

        try {
            s = getDataSet("rosalind-RNA.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter writer;

        //To realize the algorithm
        try {
            writer = new FileWriter("output.txt", StandardCharsets.UTF_8);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'T') {
                    writer.append('U');
                }
                else {
                    writer.append(s.charAt(i));
                }
            }
            writer.close();
            System.out.println("Results are saved");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
