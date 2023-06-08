package com.aktansanhal.weatherfinalcase.service.concretes;



import com.aktansanhal.weatherfinalcase.exception.exceptions.MyException;
import com.aktansanhal.weatherfinalcase.dto.CurrentWeatherDTO;
import com.aktansanhal.weatherfinalcase.dto.WeatherDTO;
import com.aktansanhal.weatherfinalcase.service.abstracts.CurrentWeatherFeignService;
import com.aktansanhal.weatherfinalcase.service.abstracts.FeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Value("${weather.apikey}")
    private String apiKey;

    @Value("${weather.units}")
    private String units;
    private final FeignService feignService;
    private final CurrentWeatherFeignService currentWeatherFeignService;



    public WeatherDTO getWeather(String cityName) {

        WeatherDTO responseData = feignService.weatherData(cityName,apiKey,units);

        if (responseData != null)
            return responseData;
        else
            throw new MyException("Listeleme Başarısız");

    }

    public CurrentWeatherDTO getCurrentWeather(String cityName) {

     	CurrentWeatherDTO responseData = currentWeatherFeignService.currentWeatherData(cityName,apiKey,units);
        if(responseData != null)
            return responseData;
        else
            throw new MyException("Listeleme Başarısız");
    }


  }





