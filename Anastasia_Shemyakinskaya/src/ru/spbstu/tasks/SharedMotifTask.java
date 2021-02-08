package ru.spbstu.tasks;

import ru.spbstu.utils.FastaFile;

import java.io.IOException;
import java.util.Map;

public class SharedMotifTask {

    public String countMaxSubstring() throws IOException {
        Map<String, String> dnaMap = FastaFile.readFileAndReturnDnaMap("shared_morif.fasta");
        String dnaString = dnaMap.values().stream().min(String::compareTo).get();
        dnaMap.values().remove(dnaString);
        String maxSubstring = "";
        for (int i = 0; i < dnaString.length(); ++i) {
            for (int j = i; j < dnaString.length(); j++) {
                String substring = dnaString.substring(i, j);
                boolean match = dnaMap.values().stream().allMatch(s -> s.contains(substring));
                if (match && (substring.length() > maxSubstring.length())) {
                    maxSubstring = substring;
                }
            }
        }
        return maxSubstring;
    }
}
