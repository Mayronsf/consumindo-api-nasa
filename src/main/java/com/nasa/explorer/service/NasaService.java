package com.nasa.explorer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NasaService {

    private static final String API_KEY = "03zBobyI30mtzlcMH5ykhnyQ9n5fAlyxZdes7Ko7";  
    private static final String NASA_API_URL = "https://api.nasa.gov/planetary/apod?api_key=" + API_KEY;

    // Lista para armazenar dados da NASA
    private List<String> nasaData = new ArrayList<>();

    public String getNasaData() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String data = restTemplate.getForObject(NASA_API_URL, String.class);
            // Adiciona o dado à lista
            nasaData.add(data); // Armazena o dado retornado
            return data;
        } catch (Exception e) {
            return "Erro ao buscar dados da NASA: " + e.getMessage();
        }
    }

    public String getNasaDataById(String id) {
        // Lógica para obter dados por ID
        return nasaData.stream().filter(data -> data.equals(id)).findFirst().orElse("Dados não encontrados");
    }

    public List<String> getAllNasaData() {
        // Retorna todos os dados armazenados
        return nasaData;
    }

    public String addNasaData(String newData) {
        // Adiciona novos dados à lista
        nasaData.add(newData);
        return "Dados adicionados com sucesso";
    }

    public String updateNasaData(String id, String updatedData) {
        for (int i = 0; i < nasaData.size(); i++) {
            if (nasaData.get(i).equals(id)) {
                nasaData.set(i, updatedData);
                return "Dados atualizados com sucesso";
            }
        }
        return "Dados não encontrados";
    }

    public String patchNasaData(String id, String partialData) {
        for (int i = 0; i < nasaData.size(); i++) {
            if (nasaData.get(i).equals(id)) {
                // Exemplo de atualização parcial: adiciona os dados parciais ao existente
                nasaData.set(i, nasaData.get(i) + " " + partialData);
                return "Dados atualizados parcialmente com sucesso";
            }
        }
        return "Dados não encontrados";
    }

    public String deleteNasaData(String id) {
        // Lógica para deletar dados por ID
        boolean removed = nasaData.removeIf(data -> data.equals(id));
        return removed ? "Dados deletados com sucesso" : "Dados não encontrados";
    }
}
