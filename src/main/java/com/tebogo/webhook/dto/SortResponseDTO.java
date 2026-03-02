package com.tebogo.webhook.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response payload containing sorted characters")
public class SortResponseDTO {


    @Schema(
            description = "Sorted list of characters",
            example = "[\"a\",\"b\",\"c\",\"d\"]"
    )
    private String[] word;
    public SortResponseDTO(String[] word) {
        this.word = word;
    }

    public String[] getWord() {
        return word;
    }

    public void setWord(String[] word) {
        this.word = word;
    }
}
