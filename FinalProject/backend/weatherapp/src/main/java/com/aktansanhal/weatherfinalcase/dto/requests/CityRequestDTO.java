package com.aktansanhal.weatherfinalcase.dto.requests;

public record CityRequestDTO(String cityName, Long userId, String temp, String infoDate, String icon) {
}
