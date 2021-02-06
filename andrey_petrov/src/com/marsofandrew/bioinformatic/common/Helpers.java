package com.marsofandrew.bioinformatic.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Function;

public final class Helpers {

    private Helpers() {
        // Not instantiable
    }

    public static String readDataSet(final String fileName) throws IOException {
        final StringBuilder builder = new StringBuilder();
        Files.lines(Path.of(fileName))
                .forEachOrdered(builder::append);
        return builder.toString();
    }

    public static void executeStringInput(Function<String, String> executor) {
        executeStringInput(executor, str -> str);
    }

    public static <T> void executeStringInput(Function<String, T> executor, Function<T, String> converter) {
        try (Scanner scanner = new Scanner(System.in)) {
            String dataSet = scanner.nextLine();
            var result = executor.apply(dataSet);
            System.out.println(converter.apply(result));
        }
    }

    public static void checkDnaFast(final String dna) {
        if (dna == null) {
            throw new IllegalArgumentException("Argument couldn't be null");
        }

        if (dna.length() > 1000) {
            throw new IllegalArgumentException("Maximum data length is 1000");
        }
    }
}
