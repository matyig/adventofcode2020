package net.solutions.matyig.adventofcode2020.day;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class Day3 implements Day {

    private String[] getInputArray(Stream<String> input) {
        return input.toArray(String[]::new);
    }

    private Optional<Long> getNumOfTrees(String[] inputArray, int right) {
        return Optional.of(IntStream.range(0, inputArray.length)
                .map( index -> getNextLocation(inputArray[index], index, right))
                .filter( location -> location == '#')
                .count());
    }

    private Character getNextLocation(String line, int index, int right) {
        var column = index * right % line.length();
        return line.toCharArray()[column];
    }

    private Optional<Long> getNumOfTreesAdvanced(String[] inputArray, int right, int down) {
        return Optional.of(IntStream.range(0, inputArray.length)
                .filter(i -> i % down == 0)
                .map( index -> getNextLocationAdvanced(inputArray[index], index, right, down))
                .filter( location -> location == '#')
                .count());
    }

    private Character getNextLocationAdvanced(String line, int index, int right, int down) {
        var column = index * right / down % line.length();
        return line.toCharArray()[column];
    }

    @Override
    public Optional<Long> first(Stream<String> input) {
        var inputArray = getInputArray(input);
        return getNumOfTrees(inputArray, 3);
    }

    @Override
    public Optional<Long> second(Stream<String> input) {
        var values = new int[][]{ {1,2}, {3,1}, {5,1}, {7,1}, {1,1}};
        var inputArray = getInputArray(input);
        return Optional.of(Arrays.stream(values)
                .map(value -> getNumOfTreesAdvanced(inputArray, value[0], value[1]))
                .flatMap(Optional::stream)
                .reduce(1L, (subtotal, treeNum) -> subtotal * treeNum));
    }

}
