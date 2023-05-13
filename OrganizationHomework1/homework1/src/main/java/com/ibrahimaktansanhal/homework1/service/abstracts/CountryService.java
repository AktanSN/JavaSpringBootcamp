package com.ibrahimaktansanhal.homework1.service.abstracts;

import com.ibrahimaktansanhal.homework1.dto.concretes.CountryReponseDTO;
import com.ibrahimaktansanhal.homework1.dto.concretes.CountryRequestDTO;
import com.ibrahimaktansanhal.homework1.dto.concretes.Country_PresidentRequestDTO;

import java.util.List;

public interface CountryService {


    CountryReponseDTO createCountry(CountryRequestDTO countryRequestDTO);

    List<CountryReponseDTO> getAllCountries();

    CountryReponseDTO getCountryById(Long countryId);

    CountryReponseDTO updateCountry(CountryRequestDTO countryRequestDTO, Long countryId);

    void deleteCountry(Long countryId);


    CountryReponseDTO updateCountry_Presedent(Long countryId, Country_PresidentRequestDTO country_presidentRequestDTO);
}
