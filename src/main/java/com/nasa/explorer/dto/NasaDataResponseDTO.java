package com.nasa.explorer.dto;

import com.nasa.explorer.model.NasaDataResponse;

public class NasaDataResponseDTO {
    private String date;
    private String title;
    private String explanation;
    private String url;

    
    public NasaDataResponseDTO(NasaDataResponse response) {
        this.date = response.getDate();
        this.title = response.getTitle();
        this.explanation = response.getExplanation();
        this.url = response.getUrl();
    }

    // Construtor padrão
    public NasaDataResponseDTO() {}

    // Getters e Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}