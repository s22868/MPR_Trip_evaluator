package com.tripEvaluator.s22868.tripEvaluators22868;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class TripEvaluatorRestControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_addTrip() throws Exception {
        mockMvc.perform(get("/trip"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"));
    }

    @Test
    void shouldReturnSuccess_addReview() throws Exception {
        String tripId = "1";
        String content = "test";
        String user = "testUser";

        mockMvc.perform(get("/trip/addReview")
                .param("tripId", tripId)
                .param("content", content)
                .param("user", user))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("Nie znaleziono Tripu o podanym id"));
    }

    @Test
    void shouldReturnSuccess_addTripWithParams() throws Exception {
        String title = "test";

        mockMvc.perform(get("/trip/addTrip")
                .param("title", title))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"title\":\"test\",\"destination\":\"na mazury\",\"reviewList\":[{\"id\":1,\"content\":\"test\",\"user\":{\"id\":1,\"name\":\"test\",\"nick\":\"testowy nick\"},\"rating\":\"TRZY_GWIAZDKI\"}],\"price\":40}"));
    }


}
