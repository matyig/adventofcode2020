package net.solutions.matyig.adventofcode2020.util;

import net.solutions.matyig.adventofcode2020.day.Day;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Component
public class Summary {

    private final List<Day> dayList;
    private final InputParser inputParser;

    public Summary(List<Day> dayList, InputParser inputParser) {
        this.dayList = dayList;
        this.inputParser = inputParser;
    }

    public void displaySolutions() {
        System.out.println("---------------------------------");
        System.out.format("%5s %12s %12s", "Day", "First", "Second");
        System.out.println();
        System.out.println("---------------------------------");
        for (Day day: dayList) {
            String className = day.getClass().getSimpleName().toLowerCase();
            Path path = Path.of("./inputs/" + className + ".txt");
            Supplier<Stream<String>> input = inputParser.getInputData(path);
            String dayStr = StringUtils.capitalize(className);
            String firstStr = day.first(input.get()).map(Object::toString).orElse("-");
            String secondStr = day.second(input.get()).map(Object::toString).orElse("-");
            System.out.format("%5s %12s %12s", dayStr, firstStr, secondStr);
            System.out.println();
        }
        System.out.println("---------------------------------");
    }
}
