package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class FindingMotifInDNATask {

    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readFile(Utils.FINDING_MOTIF_IN_DNA);
        String line = lines.get(0);
        String subLine = lines.get(1);
        StringBuilder index = new StringBuilder();
        int currentIndex = line.indexOf(subLine);

        while (currentIndex >= 0) {
            index.append(currentIndex + 1);
            index.append(" ");
            currentIndex = line.indexOf(subLine, currentIndex + 1);
        }

        System.out.println(index.deleteCharAt(index.length() - 1));
    }
}
