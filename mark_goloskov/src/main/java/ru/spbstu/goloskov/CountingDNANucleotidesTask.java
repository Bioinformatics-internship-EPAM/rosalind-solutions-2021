package ru.spbstu.goloskov;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class CountingDNANucleotidesTask {
    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readFile(Utils.COUNTING_DNA_NUCL_FILE);
        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;
        String line = lines.get(0);
        
        Multiset<Character> symbolToInteger = HashMultiset.create();
        for (int i = 0; i < line.length(); i++) {
            symbolToInteger.add(line.charAt(i));
        }
        countA = symbolToInteger.count('A');
        countC = symbolToInteger.count('C');
        countG = symbolToInteger.count('G');
        countT = symbolToInteger.count('T');
        System.out.printf("%d %d %d %d", countA, countC, countG, countT);
    }
}
