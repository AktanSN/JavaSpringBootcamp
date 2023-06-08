package com.aktansanhal.weatherfinalcase.repository;

import com.aktansanhal.weatherfinalcase.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    List<City> findByUserId(Long id);

    List<City> getByCityNameStartsWith(String cityName);

    List<City> getByCityNameContaining(String cityName);

    List<City> getAllByOrderByCityNameAsc();

}
