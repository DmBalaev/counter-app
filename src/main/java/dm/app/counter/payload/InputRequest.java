package dm.app.counter.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputRequest {
    @NotEmpty(message = "The string must not be null or empty")
    private String input;
}
