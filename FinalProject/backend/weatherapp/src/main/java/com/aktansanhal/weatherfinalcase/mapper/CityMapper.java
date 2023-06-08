package com.aktansanhal.weatherfinalcase.mapper;


import com.aktansanhal.weatherfinalcase.dto.requests.CityRequestDTO;
import com.aktansanhal.weatherfinalcase.dto.responses.CityResponseDTO;
import com.aktansanhal.weatherfinalcase.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {


    City toCity(CityRequestDTO cityRequestDTO);
    CityRequestDTO toCityRequestDTO(City city);

    City toCity(CityResponseDTO cityResponseDTO);
    CityResponseDTO toCityResponseDTO(City city);



}
