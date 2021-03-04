package Lab4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get("src/Lab4/table.txt"), StandardCharsets.UTF_8);
        for(String line: lines){
            map.put(line.substring(0,3), line.substring(4));
        }
        String rna = Files.readString(Paths.get("src/Lab4/rosalind_prot.txt"), StandardCharsets.UTF_8);
        String result;
        for (int i = 0; i < rna.length()-3; i+=3){
            result = map.get(rna.substring(i, i+3));
            if (result.equals("Stop"))
                System.out.println();
            else
                System.out.print(result);
        }
    }
}