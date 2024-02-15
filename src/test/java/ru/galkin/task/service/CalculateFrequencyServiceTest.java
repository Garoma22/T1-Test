package ru.galkin.task.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.galkin.task.utils.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class CalculateFrequencyServiceTest {

    @InjectMocks
    private CalculateFrequencyService service;

    @Mock
    private Utils utils;

    @Test
    void calculateFrequencyTest() {

        String testString = "aaaaabccc";

        try (MockedStatic<Utils> mockedStatic = Mockito.mockStatic(Utils.class)) {
            mockedStatic.when(() -> Utils.checkInputString(testString)).thenReturn(testString);

            Map<Character, Long> resultMap = service.calculateFrequencyService(testString);

            Map<Character, Long> expectedMap = new LinkedHashMap<>();
            expectedMap.put('a', 5L);
            expectedMap.put('c', 3L);
            expectedMap.put('b', 1L);

            Assertions.assertEquals(expectedMap, resultMap);
        }
    }
}