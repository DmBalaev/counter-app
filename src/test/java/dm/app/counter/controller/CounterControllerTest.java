package dm.app.counter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dm.app.counter.payload.InputRequest;
import dm.app.counter.service.CounterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CounterController.class)
class CounterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CounterService counterService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCalculateWithValidInput() throws Exception {
        InputRequest inputRequest = new InputRequest("122333");

        Map<Character, Long> expectedResult = new HashMap<>();
        expectedResult.put('1', 1L);
        expectedResult.put('2', 2L);
        expectedResult.put('3', 3L);
        when(counterService.calculate(any(String.class))).thenReturn(expectedResult);

        mockMvc.perform(get("/api/v1/calculate")
                        .content(objectMapper.writeValueAsString(inputRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    public void testCalculateWithEmptyInput() throws Exception {
        Map<Character, Long> expectedResult = new HashMap<>();
        when(counterService.calculate(any(String.class))).thenReturn(expectedResult);

        mockMvc.perform(get("/api/v1/calculate").param("input", ""))
                .andExpect(status().isBadRequest());
    }
}