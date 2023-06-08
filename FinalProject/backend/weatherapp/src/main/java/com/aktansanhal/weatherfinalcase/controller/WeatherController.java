package com.aktansanhal.weatherfinalcase.controller;



import com.aktansanhal.weatherfinalcase.kafka.ProducerService;
import com.aktansanhal.weatherfinalcase.result.generalResult.DataResult;
import com.aktansanhal.weatherfinalcase.result.generalResult.SuccessDataResult;
import com.aktansanhal.weatherfinalcase.dto.CurrentWeatherDTO;
import com.aktansanhal.weatherfinalcase.dto.WeatherDTO;
import com.aktansanhal.weatherfinalcase.service.concretes.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    private final ProducerService producerService;

    @GetMapping("/data")
    public ResponseEntity<DataResult<WeatherDTO>> getFromController(@RequestParam String cityName) {

        String record = String.format("[%s:%d] Forecast Weather data requested for %s", getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getLineNumber(), cityName);
        producerService.sendMessage(record,"debug");
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi",weatherService.getWeather(cityName)));
    }

    @GetMapping("/currentWeather")
    public ResponseEntity<DataResult<CurrentWeatherDTO>> getCurrentWeather(@RequestParam String cityName) {
        String record = String.format("[%s:%d] Current weather data requested for %s", getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getLineNumber(), cityName);
        producerService.sendMessage(record,"debug");
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi",weatherService.getCurrentWeather(cityName)));
    }




}
