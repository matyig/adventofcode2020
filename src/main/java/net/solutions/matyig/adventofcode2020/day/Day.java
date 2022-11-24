package net.solutions.matyig.adventofcode2020.day;

import java.util.Optional;
import java.util.stream.Stream;

public interface Day {

    Optional<Long> first(Stream<String> input);

    Optional<Long> second(Stream<String> input);

}
