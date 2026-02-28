package com.tebogo.webhook.dto;

public class SortReponseDTO {
    private String[] word;

    public SortReponseDTO(String[] word) {
        this.word = word;
    }

    public String[] getWord() {
        return word;
    }

    public void setWord(String[] word) {
        this.word = word;
    }
}
