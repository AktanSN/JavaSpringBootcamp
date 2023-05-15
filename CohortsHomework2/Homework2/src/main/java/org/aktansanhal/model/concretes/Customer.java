package org.aktansanhal.model.concretes;


import org.aktansanhal.model.abstracts.Person;

import java.time.LocalDate;

public class Customer extends Person {


    public Customer(String name, LocalDate registrationDate, String sector) {
        super(name, registrationDate, sector);
    }


}