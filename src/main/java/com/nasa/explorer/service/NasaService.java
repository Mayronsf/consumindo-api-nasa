package com.nasa.explorer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NasaService {

    private static final String API_KEY = "03zBobyI30mtzlcMH5ykhnyQ9n5fAlyxZdes7Ko7";  // Chave de API da NASA
    private static final String NASA_API_URL = "https://api.nasa.gov/planetary/apod?api_key=" + API_KEY;

    public String getNasaData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(NASA_API_URL, String.class);
    }
}
