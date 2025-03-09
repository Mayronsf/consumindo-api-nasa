package com.nasa.explorer.service;

import com.nasa.explorer.dto.NasaDataResponseDTO;

public abstract class AbstractNasaService {

    public abstract NasaDataResponseDTO getNasaData();

    public abstract NasaDataResponseDTO getNasaDataByDate(String date);
}
