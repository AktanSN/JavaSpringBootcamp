package com.aktansanhal.weatherfinalcase.service.concretes;


import com.aktansanhal.weatherfinalcase.entity.City;
import com.aktansanhal.weatherfinalcase.exception.exceptions.MyException;
import com.aktansanhal.weatherfinalcase.general.concretes.BaseAdditionalFields;
import com.aktansanhal.weatherfinalcase.general.abstracts.BaseEntityService;
import com.aktansanhal.weatherfinalcase.repository.CityRepository;
import com.aktansanhal.weatherfinalcase.service.abstracts.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CityServiceImpl extends BaseEntityService<City, CityRepository> implements CityService {

    @Autowired
    private CityRepository cityRepository;


    public CityServiceImpl(CityRepository cityRepository) {
        super(cityRepository);
    }


    @Override
    public City save(City city) {
        BaseAdditionalFields baseAdditionalFields = city.getBaseAdditionalFields();

        if (baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
        }

        if (city.getId()  == null){
            baseAdditionalFields.setCreatedDate(LocalDateTime.now());

            baseAdditionalFields.setCreatedBy(city.getUser().getUsername());
        }


        baseAdditionalFields.setUpdatedDate(LocalDateTime.now());

        baseAdditionalFields.setUpdatedBy(city.getUser().getUsername());

        city.setBaseAdditionalFields(baseAdditionalFields);

        cityRepository.save(city);
        return city;
    }


    @Override
    public List<City> findByUserId(Long id) {
        List<City> cities = cityRepository.findByUserId(id);
        if(cities.size()>0){
            return cities;
        }else {
            throw new MyException("Şehir Bulunamadı");
        }
    }

    @Override
    public List<City> getAllByOrderByCityNameAsc() {
        List<City> cities = cityRepository.getAllByOrderByCityNameAsc();
        if(cities.size()>0){
            return cities;
        }else {
            throw new MyException("Şehir Bulunamadı");
        }
    }

    @Override
    public List<City> getByCityNameContaining(String cityName) {
        List<City> cities = cityRepository.getByCityNameContaining(cityName);
        if(cities.size()>0){
            return cities;
        }else {
            throw new MyException(cityName+ " içeren şehir bulunamadı");
        }
    }

    @Override
    public List<City> getByCityNameStartsWith(String cityName) {
        List<City> cities = cityRepository.getByCityNameStartsWith(cityName);
        if(cities.size()>0){
            return cities;
        }else {
            throw new MyException(cityName+ " ile başlayan şehir bulunamadı");
        }
    }

    @Override
    public List<City> getCitiesPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        List<City> cities = cityRepository.findAll(pageable).getContent();
        if(cities.size()>0){
            return cities;
        }else {
            throw new MyException("Şehir Bulunamadı");
        }
    }
}
