package com.nasa.explorer.service;

import com.nasa.explorer.dto.NasaDataResponseDTO;
import com.nasa.explorer.model.NasaDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NasaService extends AbstractNasaService {

    private static final String API_KEY = "03zBobyI30mtzlcMH5ykhnyQ9n5fAlyxZdes7Ko7";
    private static final String NASA_API_URL = "https://api.nasa.gov/planetary/apod?api_key=" + API_KEY;

    private final RestTemplate restTemplate;
    private List<NasaDataResponse> nasaData = new ArrayList<>();

    @Autowired
    public NasaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public NasaDataResponseDTO getNasaData() {
        try {
            NasaDataResponse data = restTemplate.getForObject(NASA_API_URL, NasaDataResponse.class);
            if (data != null) {
                nasaData.add(data);
                return convertToDTO(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NasaDataResponseDTO getNasaDataByDate(String date) {
        NasaDataResponseDTO foundData = nasaData.stream()
                .filter(data -> data.getDate().equals(date))
                .map(this::convertToDTO)
                .findFirst()
                .orElse(null);

        if (foundData == null) {
            String apiUrlByDate = "https://api.nasa.gov/planetary/apod?api_key=" + API_KEY + "&date=" + date;
            try {
                NasaDataResponse data = restTemplate.getForObject(apiUrlByDate, NasaDataResponse.class);
                if (data != null) {
                    return convertToDTO(data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return foundData;
    }

    private NasaDataResponseDTO convertToDTO(NasaDataResponse response) {
        NasaDataResponseDTO dto = new NasaDataResponseDTO();
        dto.setDate(response.getDate());
        dto.setTitle(response.getTitle());
        dto.setExplanation(response.getExplanation());
        dto.setUrl(response.getUrl());
        return dto;
    }
}
