package net.solutions.matyig.adventofcode2020;

import net.solutions.matyig.adventofcode2020.util.Summary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AdventOfCode2020ApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void whenContextLoads_thenRunnersAreNotLoaded() {
		assertNotNull(context.getBean(Summary.class));
		assertThrows(NoSuchBeanDefinitionException.class,
				() -> context.getBean(CommandLineTaskExecutor.class),
				"CommandLineRunner should not be loaded during this integration test");
	}

}
