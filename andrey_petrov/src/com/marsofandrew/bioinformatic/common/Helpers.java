package com.marsofandrew.bioinformatic.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
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

    public static void executeStringInput(Function<String, String> inputProcessor) {
        executeStringInput(inputProcessor, Objects::toString);
    }

    public static <T> void executeStringInput(
            Function<String, T> inputProcessor, Function<T, String> outputConverter) {
        try (Scanner scanner = new Scanner(System.in)) {
            String dataSet = scanner.nextLine();
            var result = inputProcessor.apply(dataSet);
            System.out.println(outputConverter.apply(result));
        }
    }
}
