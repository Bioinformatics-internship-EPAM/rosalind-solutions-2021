import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.*;
import java.util.stream.IntStream;

public class HMM {

    public static char[] getCharactersFromLine(final String line) {
        return line.replaceAll("\\s+", "").toCharArray();
    }

    public static Table<Character, Character, Double> readMatrixFromLines(final List<String> lines,
                                                                          final char[] alphabetSymbols) {
        Table<Character, Character, Double> matrix = HashBasedTable.create();

        lines.stream()
                .map(line -> line.split("\\s+"))
                .forEach(tokens -> IntStream.range(1, tokens.length)
                        .forEach(k -> matrix
                                .put(tokens[0].charAt(0), alphabetSymbols[k - 1], Double.parseDouble(tokens[k]))
                        )
                );

        return matrix;
    }
}
