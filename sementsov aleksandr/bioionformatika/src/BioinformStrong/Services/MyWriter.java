package BioinformStrong.Services;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyWriter {

    /** special object, require for write information */
    FileWriter writer;
    final String outputPath = "submission.txt";

    public MyWriter() throws IOException {
        writer = new FileWriter(outputPath, StandardCharsets.UTF_8);
    }

    public MyWriter(boolean is_append) throws IOException {
        writer = new FileWriter(outputPath, StandardCharsets.UTF_8, is_append);
    }

    public void writeResult(char c) {
        try {
            writer.append(c);
        }
        catch(Exception ex) {

            ex.printStackTrace();
        }
    }

    public void writeResult(String s) {
        try {
            writer.write(s);
        }
        catch(Exception ex) {

            ex.printStackTrace();
        }
    }

    /** if wouldn't call, information hadn't saved*/
    public void Close() {
        try {
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
