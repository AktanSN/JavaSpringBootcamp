package com.ibrahimaktansanhal.homework1.dto.abstracts;


import com.ibrahimaktansanhal.homework1.dto.concretes.CountryReponseDTO;
import com.ibrahimaktansanhal.homework1.dto.concretes.CountryRequestDTO;
import com.ibrahimaktansanhal.homework1.dto.concretes.Country_PresidentRequestDTO;
import com.ibrahimaktansanhal.homework1.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    //CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);


    CountryRequestDTO countryToRequest(Country country);
    Country requestToCountry(CountryRequestDTO countryRequestDTO);

    CountryReponseDTO countryToResponse(Country country);
    Country responseToCountry(CountryReponseDTO countryReponseDTO);

    Country country_PresedentResponseToCountry(Country_PresidentRequestDTO country_presidentRequestDTO);



}
