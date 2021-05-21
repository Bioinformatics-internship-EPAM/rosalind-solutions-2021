import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IO {
    static String getString(String fileName) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            return fileReader.readLine();
        }
    }

    static List<String> getTwoStrings(String fileName) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            List<String> list = new ArrayList<>();
            list.add(fileReader.readLine());
            list.add(fileReader.readLine());
            return list;
        }
    }

    static String getMultipleStringsInOne(String fileName) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder dataString = new StringBuilder();
            String str;
            while ((str = fileReader.readLine()) != null) {
                if (str.charAt(0) != '>') {
                    dataString.append(str);
                }
            }
            return dataString.toString();
        }
    }

    static List<String> getListOfStrings(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> data = new ArrayList<>();
        StringBuilder dataString = new StringBuilder();
        String str;
        while ((str = fileReader.readLine()) != null) {
            if ((dataString.length() > 0) && (str.charAt(0) == '>')) {
                data.add(dataString.toString());
                dataString = new StringBuilder(str);
            } else {
                dataString.append(str);
            }
        }
        data.add(dataString.toString());
        return data;
    }

    static void writeToFile(String fileName, Collection<?> data) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Object str : data) {
                writer.write(str.toString());
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

