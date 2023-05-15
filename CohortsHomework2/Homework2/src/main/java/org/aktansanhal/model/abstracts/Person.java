package org.aktansanhal.model.abstracts;

import java.time.LocalDate;

public abstract class Person {

    private String name;

    private LocalDate registrationDate;

    private String sector;

    public Person(String name, LocalDate registrationDate, String sector) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
