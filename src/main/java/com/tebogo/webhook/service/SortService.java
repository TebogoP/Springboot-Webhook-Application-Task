package com.tebogo.webhook.service;

import com.tebogo.webhook.dto.SortResponseDTO;
import com.tebogo.webhook.exception.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SortService {

    public String[] sortAlphabetically(String word) {

        if (word == null || word.trim().isEmpty()) {
            throw new InvalidInputException("Input string cannot be null or empty");
        }

        return Arrays.stream(word.split(""))
                .sorted()
                .toArray(String[]::new);
    }

    public SortResponseDTO getResponseDTO(String word){
        String[] sortedArray = sortAlphabetically(word);
        return new SortResponseDTO(sortedArray);
    }
}