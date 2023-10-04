package dm.app.counter.request;

import dm.app.counter.payload.InputRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class InputRequestTest {
    private Validator validator;

    @BeforeEach
    public void setUp(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testInputIstEmpty() {
        InputRequest inputRequest = new InputRequest("");

        Set<ConstraintViolation<InputRequest>> violations = validator.validate(inputRequest);

        assertEquals(1, violations.size());
    }

    @Test
    public void testInputIsNull() {
        InputRequest inputRequest = new InputRequest(null);

        Set<ConstraintViolation<InputRequest>> violations = validator.validate(inputRequest);

        assertEquals(1, violations.size());
    }

    @Test
    public void testInputValid() {
        InputRequest inputRequest = new InputRequest("123123");

        Set<ConstraintViolation<InputRequest>> violations = validator.validate(inputRequest);

        assertTrue(violations.isEmpty());
    }
}