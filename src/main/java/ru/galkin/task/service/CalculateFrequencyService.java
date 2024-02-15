package ru.galkin.task.service;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.galkin.task.utils.Utils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class CalculateFrequencyService {

    private final Utils utils;

    public Map<Character, Long> calculateFrequencyService(String input) {
        Utils.checkInputString(input);
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}