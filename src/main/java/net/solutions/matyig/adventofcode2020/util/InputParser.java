package net.solutions.matyig.adventofcode2020.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Component
public class InputParser {

    public Supplier<Stream<String>> getInputData (Path filePath) {
        return () -> {
            try {
                return Files.lines(filePath);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
