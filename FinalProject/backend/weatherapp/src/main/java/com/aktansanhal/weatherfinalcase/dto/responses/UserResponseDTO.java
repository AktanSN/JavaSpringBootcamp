package com.aktansanhal.weatherfinalcase.dto.responses;

import com.aktansanhal.weatherfinalcase.general.concretes.BaseAdditionalFields;

import java.util.List;

public record UserResponseDTO(
        Long id,
        String username,
        List<CityResponseDTO> cities,
        BaseAdditionalFields baseAdditionalFields
) {

}