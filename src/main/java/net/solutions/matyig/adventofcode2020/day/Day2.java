package net.solutions.matyig.adventofcode2020.day;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.stream.Stream;

@Component
public class Day2 implements Day {

    public Optional<Long> first(Stream<String> input) {
        return Optional.of(input
                .map(this::toPassword)
                .flatMap(Optional::stream)
                .filter(this::isPasswordValid)
                .count());
    }

    public Optional<Long> second(Stream<String> input) {
        return Optional.of(input
                .map(this::toPassword)
                .flatMap(Optional::stream)
                .filter(this::isPasswordValidAdvanced)
                .count());
    }

    private Optional<Password> toPassword(String line) {
        String[] splitted = line.split(" ");
        String[] splittedNum = splitted.length == 3 ? splitted[0].split("-") : new String[0];
        if (splittedNum.length == 2) {
            return Optional.of(new Password(Integer.parseInt(splittedNum[0]),
                    Integer.parseInt(splittedNum[1]), splitted[1].charAt(0), splitted[2]));
        }
        return Optional.empty();
    }

    private boolean isPasswordValid(Password password ) {
        int count = StringUtils.countOccurrencesOf(password.password, String.valueOf(password.letter));
        return count >= password.from && count <= password.to;
    }

    private boolean isPasswordValidAdvanced(Password password ) {
        var hello1 = password.password.charAt(password.from - 1) == password.letter;
        var hello2 = password.password.charAt(password.to - 1) == password.letter;
        return ((hello1 || hello2) && !(hello1 && hello2));
    }

}

class Password {
    public int from;
    public int to;
    public char letter;
    public String password;

    Password(int from, int to, char letter, String password) {
        this.from = from;
        this.to = to;
        this.letter = letter;
        this.password = password;
    }
}
