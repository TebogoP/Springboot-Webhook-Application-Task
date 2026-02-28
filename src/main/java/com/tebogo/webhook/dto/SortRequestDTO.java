package com.tebogo.webhook.dto;

public class SortRequestDTO {

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