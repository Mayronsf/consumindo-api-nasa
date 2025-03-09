package com.nasa.explorer.controller;

import com.nasa.explorer.dto.NasaDataResponseDTO;
import com.nasa.explorer.service.AbstractNasaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/nasa")
public class NasaController {

    @Autowired
    private AbstractNasaService nasaService;

    @GetMapping("/data")
    @Operation(
            summary = "Obter dados mais recentes da NASA",
            description = "Retorna os dados mais recentes da NASA.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados encontrados"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<NasaDataResponseDTO> getData() {
        NasaDataResponseDTO data = nasaService.getNasaData();
        if (data == null) {
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/data/{date}")
    @Operation(
            summary = "Buscar dados por data específica",
            description = "Retorna os dados da NASA para a data especificada. Utilize o formato YYYY-MM-DD.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados encontrados"),
                    @ApiResponse(responseCode = "404", description = "Dados não encontrados")
            }
    )
    public ResponseEntity<NasaDataResponseDTO> getDataByDate(
            @Parameter(description = "Data no formato YYYY-MM-DD", required = true)
            @RequestParam(name = "date") String date) {
        NasaDataResponseDTO data = nasaService.getNasaDataByDate(date);
        if (data == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }
}
