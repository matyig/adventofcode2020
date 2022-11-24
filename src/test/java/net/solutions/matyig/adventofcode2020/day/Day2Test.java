package net.solutions.matyig.adventofcode2020.day;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Day2Test {

    private final Stream<String> exampleInput = Stream.of(
            "1-3 a: abcde",
                    "1-3 b: cdefg",
                    "2-9 c: ccccccccc"
    );

    @Autowired
    Day2 day2;

    @Test
    void test1() {
        var expected = 2L;
        var result = day2.first(exampleInput);
        assertThat(result).hasValue(expected);
    }

    @Test
    void test2() {
        var expected = 1L;
        var result = day2.second(exampleInput);
        assertThat(result).hasValue(expected);
    }

}


