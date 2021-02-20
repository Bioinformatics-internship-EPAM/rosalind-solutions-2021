package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class ComplementingStrandOfDNATask {
    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readDataset(Utils.COMPLEMENT_STRAND_DNA);
        StringBuilder complementDNA = new StringBuilder();
        for (char symbol : lines.get(0).toCharArray()) {
            complementDNA.append(Utils.COMPLEMENT_DNA.get(symbol));
        }
        System.out.println(complementDNA.reverse());
    }
}
