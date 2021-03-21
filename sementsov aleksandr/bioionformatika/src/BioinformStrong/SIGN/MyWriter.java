package BioinformStrong.SIGN;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyWriter {
    FileWriter writer;
    final String outputPath = "submission.txt";

    MyWriter() throws IOException {
        writer = new FileWriter(outputPath, StandardCharsets.UTF_8, true);
    }

    public void writeResult(String s) {
        try {
            writer.write(s);
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
