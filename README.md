Veteriner Yönetim Sistemi
==========================

Bu proje, veteriner klinikleri için temel yönetim işlevlerini sağlayan bir backend uygulamasıdır. Hayvanlar, müşteriler, veteriner hekimler, randevular, uygun tarihler ve aşılar gibi birçok bileşenin yönetimini sağlar. Java ve Spring Boot kullanılarak geliştirilmiştir.

🚀 Özellikler
-------------
- 🐾 Hayvan kayıtlarını ekleme, güncelleme, silme, listeleme
- 👤 Müşteri yönetimi (CRUD)
- 📅 Randevu planlama ve yönetimi
- 👨‍⚕️ Veteriner hekim uygunluk günleri yönetimi
- 💉 Aşı kayıtları ve takibi

🛠 Kullanılan Teknolojiler
--------------------------
- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL (varsayılan)

📁 Proje Yapısı
---------------
src
└── main
    └── java
        └── com.okancezik.veterinary_management
            ├── api                  → REST Controller'lar
            ├── core.dto             → Request & Response modelleri
            ├── entities             → Veritabanı Entity'leri
            ├── repositories         → JPA Repository arayüzleri
            ├── services             → Servis (iş mantığı) katmanı
            └── VeterinaryManagementApplication.java

⚙️ Kurulum
-----------
1. Reponun klonlanması:
   git clone https://github.com/buraktatarr/veterinary-management.git
   cd veterinary-management

2. `application.properties` dosyasını açarak PostgreSQL bilgilerinizi girin.

3. Uygulamayı çalıştırın:
   ./mvnw spring-boot:run

📌 Örnek API Uç Noktaları
--------------------------
| Endpoint                | Yöntem | Açıklama                     |
|-------------------------|--------|------------------------------|
| /api/animals            | GET    | Tüm hayvanları getir         |
| /api/customers          | POST   | Yeni müşteri oluştur         |
| /api/appointments       | PUT    | Randevu güncelle              |
| /api/doctors            | DELETE | Veterineri sil                |
| /api/vaccines           | GET    | Tüm aşıları getir            |

