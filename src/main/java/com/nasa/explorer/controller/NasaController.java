package com.nasa.explorer.controller; 

import com.nasa.explorer.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nasa")
public class NasaController {

    @Autowired
    private NasaService nasaService;

    @GetMapping("/data")
    public String getData() {
        return nasaService.getNasaData();
    }
}
