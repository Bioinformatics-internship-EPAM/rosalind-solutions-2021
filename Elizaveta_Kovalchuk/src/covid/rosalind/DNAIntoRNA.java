package covid.rosalind;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DNAIntoRNA {

    public static String createRNA(String t) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer(t);
        while (i < stringBuffer.length()) {
            if (stringBuffer.charAt(i) == 'T') {
                stringBuffer.setCharAt(i, 'U');
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/covid/rosalind/DNAIntoRNA.txt";
        String pathOut = "src/covid/rosalind/DNAIntoRNARes.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        String str = scanner.nextLine();
        fileWriter.write(createRNA(str));
        fileReader.close();
        fileWriter.close();
    }
}
