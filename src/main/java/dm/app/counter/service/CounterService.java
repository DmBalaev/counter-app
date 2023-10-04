package dm.app.counter.service;

import java.util.Map;

public interface CounterService {
    Map<Character, Long> calculate(String input);
}
