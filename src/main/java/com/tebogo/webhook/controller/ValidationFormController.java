package com.tebogo.webhook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tebogo.webhook.dto.ValidationFormDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class ValidationFormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("validationForm", new ValidationFormDTO());
        return "index";
    }

    @PostMapping("/form")
    public String submitForm(
            @ModelAttribute("validationForm") ValidationFormDTO form,
            Model model) {

        String validationUrl =
                "https://yhxzjyykdsfkdrmdxgho.supabase.co/functions/v1/application-task"
                        + "?url=" + form.getEndpoint()
                        + "&email=" + form.getEmail();

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    validationUrl,
                    HttpMethod.GET,
                    null,
                    String.class
            );

            model.addAttribute("response", formatJson(response.getBody()));

        } catch (HttpStatusCodeException ex) {

            model.addAttribute("response", formatJson(ex.getResponseBodyAsString()));

        } catch (RestClientException ex) {

            model.addAttribute("response", "Request failed: " + ex.getMessage());
        }

        return "index";
    }
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String formatJson(String json) {
        try {
            Object jsonObject = objectMapper.readValue(json, Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(jsonObject);
        } catch (Exception e) {
            return json;
        }
    }
}