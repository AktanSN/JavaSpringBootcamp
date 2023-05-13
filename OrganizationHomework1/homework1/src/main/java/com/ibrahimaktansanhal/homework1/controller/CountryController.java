package com.ibrahimaktansanhal.homework1.controller;


import com.ibrahimaktansanhal.homework1.dto.concretes.CountryReponseDTO;
import com.ibrahimaktansanhal.homework1.dto.concretes.CountryRequestDTO;
import com.ibrahimaktansanhal.homework1.dto.concretes.Country_PresidentRequestDTO;
import com.ibrahimaktansanhal.homework1.service.abstracts.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public List<CountryReponseDTO> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/{countryId}")
    public CountryReponseDTO getCountryById(@PathVariable Long countryId){
        return countryService.getCountryById(countryId);
    }

    @PostMapping
    public CountryReponseDTO createCountry(@RequestBody CountryRequestDTO countryRequestDTO){
        return countryService.createCountry(countryRequestDTO);
    }

    @PutMapping("/{countryId}")
    public CountryReponseDTO updateCountry(@RequestBody CountryRequestDTO countryRequestDTO, @PathVariable Long countryId){
        return countryService.updateCountry(countryRequestDTO,countryId);
    }

    @PutMapping("/updatePresedent/{countryId}")
    public CountryReponseDTO updateCountry_Presedent(@PathVariable Long countryId, @RequestBody Country_PresidentRequestDTO country_presidentRequestDTO){
        return countryService.updateCountry_Presedent(countryId,country_presidentRequestDTO);
    }



    @DeleteMapping("/{countryId}")
    public void deleteCountry(@PathVariable Long countryId){
        countryService.deleteCountry(countryId);
    }
}
