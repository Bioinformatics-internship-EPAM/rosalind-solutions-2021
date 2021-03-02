package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        String c = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            c = br.readLine();
        }

        char[] dna = c.toCharArray();

        Map<Character, Integer> counters = new HashMap<Character, Integer>(Map.of(
                'A', 0,
                'C', 0,
                'G', 0,
                'T', 0
        ));

        for (int i = 0; i < dna.length; i++){
            char key = dna[i];
            if (!counters.containsKey(key)) {
                continue;
            }

            counters.compute(key, (k, value) -> ++value);
        }

        System.out.print(counters.get('A') + " " + counters.get('C') + " "+ counters.get('G') + " " + counters.get('T'));
    }
}
