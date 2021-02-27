package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class ComplementingStrandOfDNATask {
    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readFile(Utils.COMPLEMENT_STRAND_DNA);
        System.out.println(Utils.reverseComplement(lines.get(0)));
    }
}
