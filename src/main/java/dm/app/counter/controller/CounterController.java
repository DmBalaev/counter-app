package dm.app.counter.controller;

import dm.app.counter.payload.InputRequest;
import dm.app.counter.service.CounterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calculate")
public class CounterController {
    private final CounterService counterService;

    @GetMapping
    public Map<Character, Long> calculateFrequency(@Valid @RequestBody InputRequest request){
        return counterService.calculate(request.getInput());
    }
}
