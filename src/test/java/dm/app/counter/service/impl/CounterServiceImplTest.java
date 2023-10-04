package dm.app.counter.service.impl;

import dm.app.counter.exceptions.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {"app.maxLength=10"})
class CounterServiceImplTest {
    @Autowired
    private CounterServiceImpl counterService;

    @Test
    @DisplayName("Correct input")
    public void testCalculate() {
        String input = "aaaaaccccb";

        Map<Character, Long> result = counterService.calculate(input);

        assertNotNull(result);
        assertEquals(5L, result.get('a'));
        assertEquals(4L, result.get('c'));
        assertEquals(1L, result.get('b'));
    }

    @Test
    @DisplayName("Incorrect length")
    public void incorrectLength(){
        String input = "111111111111111111111";

        assertThrows(InvalidInputException.class,()-> counterService.calculate(input));
    }
}