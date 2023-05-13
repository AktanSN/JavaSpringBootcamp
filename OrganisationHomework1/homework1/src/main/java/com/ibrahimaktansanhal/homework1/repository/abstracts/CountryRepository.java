package com.ibrahimaktansanhal.homework1.repository.abstracts;


import com.ibrahimaktansanhal.homework1.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {


}
