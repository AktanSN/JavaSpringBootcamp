package com.ibrahimaktansanhal.homework1.service.concretes;


import com.ibrahimaktansanhal.homework1.dto.abstracts.CountryMapper;
import com.ibrahimaktansanhal.homework1.dto.concretes.CountryReponseDTO;
import com.ibrahimaktansanhal.homework1.dto.concretes.CountryRequestDTO;
import com.ibrahimaktansanhal.homework1.dto.concretes.Country_PresidentRequestDTO;
import com.ibrahimaktansanhal.homework1.entity.Country;
import com.ibrahimaktansanhal.homework1.repository.abstracts.CountryRepository;
import com.ibrahimaktansanhal.homework1.service.abstracts.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }


    @Override
    public CountryReponseDTO createCountry(CountryRequestDTO countryRequestDTO) {
        Country country = countryMapper.requestToCountry(countryRequestDTO);
        country.setName(country.getName());
        country.setPresident(country.getPresident());
        return countryMapper.countryToResponse(countryRepository.save(country));
    }

    @Override
    public List<CountryReponseDTO> getAllCountries() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryReponseDTO> countryReponseDTOList = countryList.stream().map(country -> countryMapper.countryToResponse(country)).collect(Collectors.toList());
        return countryReponseDTOList;
    }


    @Override
    public CountryReponseDTO getCountryById(Long countryId) {
        Optional<Country> country = countryRepository.findAll().stream().filter(temp -> temp.getId() == countryId).findFirst();
        if(country.isPresent()){
            return countryMapper.countryToResponse(country.get());
        }
        return null;
    }

    @Override
    public CountryReponseDTO updateCountry(CountryRequestDTO countryRequestDTO, Long countryId) {
        Optional<Country> country = countryRepository.findAll().stream().filter(temp -> temp.getId() == countryId).findFirst();
        if(country.isPresent()){
            Country lastCountry = country.get();
            lastCountry.setName(countryRequestDTO.name());
            lastCountry.setPresident(countryRequestDTO.president());
            return countryMapper.countryToResponse(countryRepository.save(lastCountry));
        }
        return null;
    }

    @Override
    public void deleteCountry(Long countryId) {
        Optional<Country> country = countryRepository.findAll().stream().filter(temp -> temp.getId() == countryId).findFirst();
        if(country.isPresent()){
            countryRepository.deleteById(countryId);
        }
    }

    @Override
    public CountryReponseDTO updateCountry_Presedent(Long countryId, Country_PresidentRequestDTO country_presidentRequestDTO) {
        CountryReponseDTO country = getCountryById(countryId);
        if(country != null){
            Country lastCountry = countryMapper.responseToCountry(country);
            lastCountry.setPresident(country_presidentRequestDTO.president());
            return countryMapper.countryToResponse(countryRepository.save(lastCountry));
        }
        return null;
    }


}
