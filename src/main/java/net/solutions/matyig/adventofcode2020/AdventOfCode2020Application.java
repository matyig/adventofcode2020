package net.solutions.matyig.adventofcode2020;

import net.solutions.matyig.adventofcode2020.util.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventOfCode2020Application implements CommandLineRunner {

	Summary summary;

	@Autowired
	public AdventOfCode2020Application(Summary summary) {
		this.summary = summary;
	}

	@Override
	public void run(String args[]) throws Exception {
		summary.displaySolutions();
	}

	public static void main(String[] args) {
		SpringApplication.run(AdventOfCode2020Application.class, args);
	}

}
