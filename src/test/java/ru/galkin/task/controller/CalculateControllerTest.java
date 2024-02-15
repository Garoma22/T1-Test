package ru.galkin.task.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.galkin.task.service.CalculateFrequencyService;
import java.util.Map;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateControllerTest {

    @InjectMocks
    private CalculateController controller;

    @Mock
    private CalculateFrequencyService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testCalculateFrequency() throws Exception {
        String input = "aaaaabccc";
        Map<Character, Long> expectedResult = Map.of('a', 5L, 'c', 3L, 'b', 1L);

        when(service.calculateFrequencyService(input)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/test/calculate-frequency")
                        .param("input", input))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.a").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.c").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.b").value(1));
    }
}