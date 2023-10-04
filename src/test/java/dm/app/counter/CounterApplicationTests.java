package dm.app.counter;

import dm.app.counter.controller.CounterController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CounterApplicationTests {
	@Autowired
	private CounterController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
