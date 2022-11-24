package net.solutions.matyig.adventofcode2020.day;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Day3Test {

    private final Stream<String> exampleInput = Stream.of(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
    );

    @Autowired
    Day3 day3;

    @Test
    void test1() {
        var expected = 7L;
        var result = day3.first(exampleInput);
        assertThat(result).hasValue(expected);
    }

    @Test
    void test2() {
        var expected = 336L;
        var result = day3.second(exampleInput);
        assertThat(result).hasValue(expected);
    }

}
