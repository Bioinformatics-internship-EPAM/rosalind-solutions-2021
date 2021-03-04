package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class CountingPointMutationsTask {

    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readFile(Utils.COUNTING_POINT_MUTATIONS);
        String line1 = lines.get(0);
        String line2 = lines.get(1);
        int countMutations = 0;
        for (int i = 0; i < line1.length(); i++) {
            if (line1.charAt(i) != line2.charAt(i))
                countMutations++;

        }
        System.out.println(countMutations);
    }
}
