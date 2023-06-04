# homework

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
* Setup SDK uyarısı alırsanız: Oracle OpenJDK 19.0.2 kullanıldı.

## Kullanılan Teknolojiler ve IDE
* Maven
* Spring Boot
  * Spring Web
  * Spring Boot DevTools
  * Spring Data JPA
  * MapStruct
  * Swagger
  * Lombok
* PostgreSQL
* IntelliJ IDEA

## Kurulum ve Çalıştırma

Veritabanı olarak PostgreSQL kullanıldı.Kendi kodumda konfigürasyon hw2 adında bir veritabanı ile yapıldı.
Spring boot projesine girerek resources içerisindeki ""application.properties"" dosyasında gerekli değişiklikler yapılmalı.
```
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/hw2
spring.datasource.username=postgres
spring.datasource.password=24862486
spring.jpa.properties.javax.persistence.validation.mode = none

spring.main.allow-circular-references=true
```


# API Definitions

![Photo]()

# DTO Schemas
![Photo]()

