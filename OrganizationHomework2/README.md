

# Homework

## Gereklilikler
```
Ödev -2:
Bir online alışveriş sitesinin backend servisi için;
- Kullanıcı, Ürün ve yorumları yöneten bir servistir.
- Bir bir e-maili ve bir telefon numarası sadece bir kullanıcıya ait olabilir.
- Aynı kullanıcı adı, telefon ya da e-mail ile kayıt yapılamaz.
- Kullanıcı tipi kişi ya da kurum olabilir.
1. Ürün controller ında;
1.1.Ürün kaydeden bir servis yazınız.
1.2.Ürünleri listeleyebilen bir servis yazınız.
1.3.Ürün idsinden ürünü bulan bir servis yazınız.
1.4.Ürün silen bir metot yazınız.
1.5.Ürün fiyatı güncelleyen bir metot yazınız. (Sadece fiyat)
2. Kullanıcı controller ında;
2.1.Tüm kullanıcıları getiren bir servis yazınız.
2.2.Kullanıcı idsinden kullanıcıyı getiren bir servis yazınız.
2.3.Kullanıcı adından kullanıcıyı getiren bir servis yazınız.
2.4.Kullanıcı kaydedilebilecek bir servis yazınız.
2.5.Kullanıcı silebilecek bir servis yazınız. (kullanıcı adı, ve telefon bilgileri alınmalı). Eğer kullanıcı
adı ve telefon uyuşmuyorsa “XXX kullanıcı adı ile YYY telefonu bilgileri uyuşmamaktadır.”
şeklinde bir uyarı vermeil.
2.6.Kullanıcı bilgilerini güncelleyebilecek bir servis yazınız.
3. Yorum Controller ında;
3.1.Bir kullanıcının yaptığı yorumlari getiren bir servis yazınız. Eğer ilgili kullanıcının henüz bir
yorumu yoksa “XXX kullanıcı henüz bir yorum yazmamıştır” şeklinde bir hata vermeli.
3.2.Bir ürüne yapılan tüm yorumları getiren bir servis yazınız. Eğer o ürüne henüz bir yorum
yazılmamışsa “XXX ürüne henüz bir yorum yazılmamıştır” şeklinde bir hata vermeli.
3.3.Yeni bir yorum yazılabilecek bir servis yazınız.
3.4.Yorum silebilecek bir servis yazınız.
Not:
Yukarıdaki hiçbir servis Persistance nesne (entity) almamalı ya da dönmemelidir.
Pathlere dikkat ediniz.
Repository ve entityService deki method isimlerine dikkat ediniz.
BaseEntityService, BaseEntity vs bunları kendiniz yazarak kodu anlamaya çalışınız.
Exception handling mekanizması kurunuz. (Controller Advice)
Tüm entitylerde kaydetme tarihi, güncelleme tarihi, kaydeden, güncelleyen olmalı. 
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

![Photo](https://user-images.githubusercontent.com/58556840/243149697-dd0fea0d-21cb-47c7-9469-a2c9736c4fff.png)
![Photo](https://user-images.githubusercontent.com/58556840/243149699-8ccc21a9-c30e-4d6b-a4d4-4c36810e6e58.png)
![Photo](https://user-images.githubusercontent.com/58556840/243149701-61fd5bbb-07fd-405f-9d4e-94e9699e8395.png)
# DTO Schemas
![Photo](https://user-images.githubusercontent.com/58556840/243149702-85212325-26dc-44e6-aafc-898cf43e251e.png)
![Photo](https://user-images.githubusercontent.com/58556840/243149703-8c58fe8c-eef5-4cc5-98d5-12ce9852deed.png)
![Photo](https://user-images.githubusercontent.com/58556840/243149704-0bb4e094-9e90-42ce-a730-6e2880caed60.png)

