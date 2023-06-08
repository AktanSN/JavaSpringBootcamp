package com.aktansanhal.weatherfinalcase.controller.contract;

import com.aktansanhal.weatherfinalcase.dto.requests.CityRequestDTO;
import com.aktansanhal.weatherfinalcase.dto.responses.CityResponseDTO;

import java.util.List;

public interface CityControllerContract {
    CityResponseDTO saveCity(CityRequestDTO cityRequestDTO);

    List<CityResponseDTO> getAllCities();

    CityResponseDTO getCityById(Long id);

    List<CityResponseDTO> getCitiesByUserId(Long id);

    CityResponseDTO deleteCityById(Long id);

    List<CityResponseDTO> getAllCitiesOrderByCityName();

    List<CityResponseDTO> getCitiesByCityNameContains(String cityName);

    List<CityResponseDTO> getCitiesByCityNameStartsWith(String cityName);

    List<CityResponseDTO> getCitiesByPage(int i, int size);

    CityResponseDTO updateCity(Long id, CityRequestDTO cityRequestDTO);
}
