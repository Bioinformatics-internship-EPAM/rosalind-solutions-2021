package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class FindingMotifInDNATask {

    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readDataset(Utils.FINDING_MOTIF_IN_DNA);
        String line = lines.get(0);
        String subLine = lines.get(1);
        int cycleLength = line.length() - subLine.length();
        StringBuilder index = new StringBuilder();

        for (int i = 0; i < cycleLength; i++) {
            int j = 0;
            for (j = 0; j < subLine.length(); j++) {
                if (line.charAt(i+j) != subLine.charAt(j))
                    break;
            }
            if (j == subLine.length()) {
                index.append(i + 1);
                index.append(" ");
            }
        }

        System.out.println(index.deleteCharAt(index.length() - 1));
    }
}
