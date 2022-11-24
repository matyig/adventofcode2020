package net.solutions.matyig.adventofcode2020.day;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Day1Test {

    private final Stream<String> exampleInput = Stream.of(
            "1721",
            "979",
            "366",
            "299",
            "675",
            "1456"
            );

    @Autowired
    Day1 day1;

    @Test
    void test1() {
        var expected = 514579L;
        var result = day1.first(exampleInput);
        assertThat(result).hasValue(expected);
    }

    @Test
    void test2() {
        var expected = 241861950L;
        var result = day1.second(exampleInput);
        assertThat(result).hasValue(expected);
    }

}
