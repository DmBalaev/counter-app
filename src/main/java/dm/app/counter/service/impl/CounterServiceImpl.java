package dm.app.counter.service.impl;

import dm.app.counter.exceptions.InvalidInputException;
import dm.app.counter.service.CounterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CounterServiceImpl implements CounterService {
    @Value("${app.maxLength}")
    private int maxLength;
    @Override
    public Map<Character, Long> calculate(String input) {
        if (input.length() > maxLength){
            throw new InvalidInputException("Input string is too long. Maximum allowed length is " + maxLength);
        }

        Map<Character, Long> frequency = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        return frequency.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}
