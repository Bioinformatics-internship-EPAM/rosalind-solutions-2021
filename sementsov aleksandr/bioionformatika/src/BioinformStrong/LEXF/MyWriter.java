package BioinformStrong.LEXF;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyWriter {
    FileWriter writer;
    final String outputPath = "submission.txt";

    MyWriter() throws IOException {
        writer = new FileWriter(outputPath, StandardCharsets.UTF_8);
    }

    public void writeResult(char c) {
        try {
            writer.append(c);
        }
        catch(Exception ex) {

            ex.printStackTrace();
        }
    }

    public void Close() {
        try {
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
