package com.marsofandrew.bioinformatic.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collector;

public final class IOUtils {

    private IOUtils() {
        // Not instantiable
    }

    public static String readDataSet(final String fileName) throws IOException {
        final StringBuilder builder = new StringBuilder();
        Files.lines(Path.of(fileName))
                .forEachOrdered(builder::append);

        return builder.toString();
    }
}
