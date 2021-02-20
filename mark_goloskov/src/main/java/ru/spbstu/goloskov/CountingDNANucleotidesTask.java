package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class CountingDNANucleotidesTask {
    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readDataset(Utils.COUNTING_DNA_NUCL_FILE);
        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;
        for (char symbol : lines.get(0).toCharArray()) {
            switch (symbol){
                case 'A' :
                    countA++;
                    break;
                case 'C' :
                    countC++;
                    break;
                case 'G' :
                    countG++;
                    break;
                case 'T' :
                    countT++;
                    break;
            }
        }
        System.out.printf("%d %d %d %d", countA, countC, countG, countT);
    }
}
