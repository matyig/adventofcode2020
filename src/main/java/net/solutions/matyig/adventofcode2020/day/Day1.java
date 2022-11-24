package net.solutions.matyig.adventofcode2020.day;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

@Component
public class Day1 implements Day {

    private Long[] getInputArray(Stream<String> input) {
        return input.map(Long::valueOf).toArray(Long[]::new);
    }

    public Optional<Long> first(Stream<String> input) {
        var inputArray = getInputArray(input);
        for (int i = 0; i < inputArray.length-2; i++) {
            for (int j = i; j < inputArray.length-1; j++) {
                if (inputArray[i]+inputArray[j] == 2020) {
                    return Optional.of(inputArray[i]*inputArray[j]);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Long> second(Stream<String> input) {
        var inputArray = getInputArray(input);
        for (int i = 0; i < inputArray.length-3; i++) {
            for (int j = i; j < inputArray.length-2; j++) {
                for (int k = j; k < inputArray.length-1; k++) {
                    if (inputArray[i] + inputArray[j] + inputArray[k] == 2020) {
                        return Optional.of(inputArray[i] * inputArray[j] * inputArray[k]);
                    }
                }
            }
        }
        return Optional.empty();
    }

}
