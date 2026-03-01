package com.tebogo.webhook;

import com.tebogo.webhook.controller.SortController;
import com.tebogo.webhook.service.SortService;
import com.tebogo.webhook.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest(SortController.class)
@Import({SortService.class, GlobalExceptionHandler.class})
class SortControllerMockitoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testEndpointExistsAndReturns200() throws Exception {

        String simpleJson = "{\"data\":\"abc\"}";

        mockMvc.perform(post("/api/sort")
                        .contentType("application/json")
                        .content(simpleJson))
                .andExpect(status().isOk());
    }


    @Test
    void test200StatusEndpointResponsesBodyKeyIsWord() throws Exception {
        String simpleJson = "{\"data\":\"abc\"}";
        mockMvc.perform(post("/api/sort")
                        .contentType("application/json")
                        .content(simpleJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.word").exists());

    }
    @Test
    void testEndpointExistsAndReturns400() throws Exception{
        String simpleJson = "{\"data\":\"\"}";
        mockMvc.perform(post("/api/sort")
                        .contentType("application/json")
                        .content(simpleJson))
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void testBadRequestResponseHasCorrectResponsesKeys() throws Exception{

        String simpleJson = "{\"data\":\"\"}";
        mockMvc.perform(post("/api/sort")
                        .contentType("application/json")
                        .content(simpleJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.error").exists())
                .andExpect(jsonPath("$.message").exists());

    }

    @Test
    void testReturnsAnArray() throws Exception {
        String simpleJson = "{\"data\":\"bca\"}";
        mockMvc.perform(post("/api/sort")
                        .contentType("application/json")
                        .content(simpleJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.word").isArray());
    }

    @Test
    void shouldReturnSortedCharacters1() throws Exception {
        String simpleJson = "{\"data\":\"bca\"}";
        mockMvc.perform(post("/api/sort")
                        .contentType("application/json")
                        .content(simpleJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.word[0]").value("a"))
                .andExpect(jsonPath("$.word[1]").value("b"))
                .andExpect(jsonPath("$.word[2]").value("c"));
    }

    @Test
    void testReturnsFullProperErrorBodyWhenInputIsInvalid() throws Exception {

        String simpleJson = "{\"data\":\"\"}";
        mockMvc.perform(post("/api/sort")
                        .contentType("application/json")
                        .content(simpleJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message")
                        .value("Input string cannot be null or empty"));
    }

    @Test
    void testReturnSortedCharacters2() throws Exception {
        String simpleJson = "{\"data\":\"example\"}";
        mockMvc.perform(post("/api/sort")
                        .contentType("application/json")
                        .content(simpleJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.word[0]").value("a"))
                .andExpect(jsonPath("$.word[1]").value("e"))
                .andExpect(jsonPath("$.word[2]").value("e"))
                .andExpect(jsonPath("$.word[3]").value("l"))
                .andExpect(jsonPath("$.word[4]").value("m"))
                .andExpect(jsonPath("$.word[5]").value("p"))
                .andExpect(jsonPath("$.word[6]").value("x"));
    }


}
