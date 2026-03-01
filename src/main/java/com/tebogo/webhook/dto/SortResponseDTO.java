package com.tebogo.webhook.dto;

public class SortResponseDTO {
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
