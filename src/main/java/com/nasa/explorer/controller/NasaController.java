package com.nasa.explorer.controller;

import com.nasa.explorer.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nasa")
public class NasaController {

    @Autowired
    private NasaService nasaService;

    // Endpoint para obter dados da NASA
    @GetMapping("/data")
    public ResponseEntity<String> getData() {
        String data = nasaService.getNasaData();
        if (data == null || data.startsWith("Erro")) {
            return ResponseEntity.status(500).body(data); // Retorna 500 em caso de erro
        }
        return ResponseEntity.ok(data);
    }

    // Endpoint para obter dados específicos por ID
    @GetMapping("/data/{id}")
    public ResponseEntity<String> getDataById(@PathVariable String id) {
        String data = nasaService.getNasaDataById(id);
        if (data.equals("Dados não encontrados")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    // Endpoint para obter uma lista de dados
    @GetMapping("/data/list")
    public ResponseEntity<List<String>> getAllData() {
        List<String> allData = nasaService.getAllNasaData();
        return ResponseEntity.ok(allData);
    }

    // Endpoint para adicionar novos dados
    @PostMapping("/data")
    public ResponseEntity<String> addData(@RequestBody String newData) {
        String response = nasaService.addNasaData(newData);
        return ResponseEntity.ok(response);
    }

    // Endpoint para atualizar dados existentes (PUT)
    @PutMapping("/data/{id}")
    public ResponseEntity<String> updateData(@PathVariable String id, @RequestBody String updatedData) {
        String response = nasaService.updateNasaData(id, updatedData);
        if (response.equals("Dados não encontrados")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    // Endpoint para atualizar parcialmente dados existentes (PATCH)
    @PatchMapping("/data/{id}")
    public ResponseEntity<String> patchData(@PathVariable String id, @RequestBody String partialData) {
        String response = nasaService.patchNasaData(id, partialData);
        if (response.equals("Dados não encontrados")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    // Endpoint para deletar dados por ID
    @DeleteMapping("/data/{id}")
    public ResponseEntity<String> deleteData(@PathVariable String id) {
        String response = nasaService.deleteNasaData(id);
        return ResponseEntity.ok(response);
    }
}