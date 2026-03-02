package com.tebogo.webhook.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request payload containing the string to be sorted")
public class SortRequestDTO {

    @Schema(
            description = "The string to sort alphabetically",
            example = "dcba"
    )
    private String data;

    public SortRequestDTO() {
    }

    public SortRequestDTO(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}