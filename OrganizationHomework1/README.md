# Homework

## Gereklilikler
```
-Ülke: id, name, president
  Ülke kaydeden bir api yazınız. 
  Tüm ülkeleri getiren bir api yazınız
  Id den ülke getiren bir api yazınız. 
  Ülke başkanını güncelleyen bir api yazınız
```
## Dikkat
* Setup SDK uyarısı alırsanız: Oracle OpenJDK 17.0.4 kullanıldı.

## Kullanılan Teknolojiler ve IDE
* Maven
* Spring Boot
  * Spring Web
  * Spring Boot DevTools
  * Spring Data JPA
  * MapStruct
  * Swagger
* PostgreSQL
* IntelliJ IDEA

## Kurulum ve Çalıştırma

Veritabanı olarak PostgreSQL kullanıldı.Kendi kodumda konfigürasyon msdb adında bir veritabanı ile yapıldı.
Spring boot projesine girerek resources içerisindeki ""application.properties"" dosyasında gerekli değişiklikler yapılmalı.
```
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/msdb
spring.datasource.username=postgres
spring.datasource.password=24862486
spring.jpa.properties.javax.persistence.validation.mode = none
```


# API Definitions

![Photo](https://user-images.githubusercontent.com/58556840/238549887-d6d00908-2485-46cc-83f2-a42244504cb0.png)

# DTO Schemas
![Photo](https://user-images.githubusercontent.com/58556840/238549886-e1345182-13b9-4090-adcc-8c3aaca573a0.png)

## Post 
![Photo](https://user-images.githubusercontent.com/58556840/238549897-31a08858-5774-4f67-a9f0-9b9e162a0d7c.png)

## Post Database View
![Photo](https://user-images.githubusercontent.com/58556840/238549898-235f75b8-dc1e-4b95-984e-ef5977653a12.png)
## GetAll
![Photo](https://user-images.githubusercontent.com/58556840/238549892-2dd91a0e-c850-4074-a0a2-dfb847e44e22.png)

## GetByCountryId
![Photo](https://user-images.githubusercontent.com/58556840/238549894-4f94b479-7d8f-4aaa-85c1-c8d680148829.png)

## UpdatePresedentName
![Photo](https://user-images.githubusercontent.com/58556840/238549883-8aa05cb5-f19b-4a55-b403-c81a3898d936.png)
## UpdatePresedentName Database View
![Photo](https://user-images.githubusercontent.com/58556840/238549906-990a8207-3378-461b-965f-7bc2126a30bd.png)

## UpdateCountryNameAndPresedentName
![Photo](https://user-images.githubusercontent.com/58556840/238549900-ae32b5dd-80cc-41e4-8311-2e6026c206a6.png)

## UpdateCountryNameAndPresedentName Database View
![Photo](https://user-images.githubusercontent.com/58556840/238549902-75ccc7de-a2b5-426a-a2c7-5d054ab5605d.png)

## DeleteCountry 
![Photo](https://user-images.githubusercontent.com/58556840/238549890-e7088cf3-0171-402e-9149-0ebc1952f8d1.png)

## DeleteCountry Database View
![Photo](https://user-images.githubusercontent.com/58556840/238549891-cfd9aab8-beac-463e-b6f5-0f5e8371d4b3.png)
