package com.aktansanhal.weatherfinalcase.dto.responses;

import com.aktansanhal.weatherfinalcase.general.concretes.BaseAdditionalFields;

public record CityResponseDTO(
        Long id,
        String cityName,

        String temp,

        String infoDate,

        String icon,
        BaseAdditionalFields baseAdditionalFields
) {

}