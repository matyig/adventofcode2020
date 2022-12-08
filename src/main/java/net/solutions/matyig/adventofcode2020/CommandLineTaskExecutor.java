package net.solutions.matyig.adventofcode2020;

import net.solutions.matyig.adventofcode2020.util.Summary;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class CommandLineTaskExecutor  implements CommandLineRunner {

    Summary summary;

    public CommandLineTaskExecutor(Summary summary) {
        this.summary = summary;
    }

    @Override
    public void run(String args[]) {
        summary.displaySolutions();
    }
}
