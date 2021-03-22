package PROT;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {
    static final int CODON_LENGTH = 3;
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get("src/PROT/table.txt"), StandardCharsets.UTF_8);
        for(String line: lines){
            map.put(line.substring(0,CODON_LENGTH), line.substring(CODON_LENGTH+1));
        }
        String rna = Files.readString(Paths.get("src/PROT/rosalind_prot.txt"), StandardCharsets.UTF_8);
        String result;
        for (int i = 0; i < rna.length()-CODON_LENGTH; i+=CODON_LENGTH){
            result = map.get(rna.substring(i, i+CODON_LENGTH));
            if (result.equals("Stop")) {
                break;
            } else {
                System.out.print(result);
            }
        }
    }
}
