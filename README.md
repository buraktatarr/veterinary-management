# 🐾 Veterinary Management System

Veterinary Management System, veteriner kliniklerinin dijital ihtiyaçlarını karşılamak amacıyla geliştirilmiş RESTful API tabanlı bir web uygulamasıdır. Bu sistem, veteriner hekimlerin hasta hayvan kayıtlarını, sahip bilgilerini, randevu süreçlerini ve aşı geçmişlerini merkezi olarak yönetmelerini sağlar.

---

## 📋 İçindekiler

- [Proje Hakkında](#-proje-hakkında)
- [Kullanılan Teknolojiler](#-kullanılan-teknolojiler)
- [Kurulum](#-kurulum)
- [API Özellikleri](#-api-özellikleri)
  - [Doktor Yönetimi](#doktor-yönetimi)
  - [Müsaitlik Günleri](#müsaitlik-günleri)
  - [Müşteri ve Hayvan Yönetimi](#müşteri-ve-hayvan-yönetimi)
  - [Aşı Takibi](#aşı-takibi)
  - [Randevu Yönetimi](#randevu-yönetimi)
- [Hata Yönetimi](#-hata-yönetimi)
- [Notlar](#-notlar)

---

## 📌 Proje Hakkında

Bu proje, veterinerlik hizmetlerinin dijitalleştirilmesini ve günlük operasyonların kolaylaştırılmasını amaçlar. Kullanıcılar; doktor, müşteri, hayvan, aşı ve randevu gibi temel varlıkları REST API aracılığıyla yönetebilirler.

---

## 💻 Kullanılan Teknolojiler

- Java 21  
- Spring Boot 3.5  
- Spring Data JPA  
- PostgreSQL  
- ModelMapper  
- Maven  

---

## ⚙️ Kurulum

1. PostgreSQL üzerinde bir veritabanı oluşturun.
2. `application.properties` dosyasında bağlantı bilgilerinizi güncelleyin.
3. Projeyi klonlayın:

   ```bash
   git clone <repo-url>

## 🧩 API Özellikleri

### 📌 Doktor Yönetimi

- **POST** `/api/v1/doctors` → Yeni doktor ekler  
- **PUT** `/api/v1/doctors/{id}` → Doktor bilgilerini günceller  
- **DELETE** `/api/v1/doctors/{id}` → Doktoru siler  
- **GET** `/api/v1/doctors/{id}` → Belirli ID ile doktor bilgisi getirir  
- **GET** `/api/v1/doctors` → Tüm doktorları listeler  
- **GET** `/api/v1/doctors/search?name={name}` → İsimle doktor arar  

---

### 📆 Müsaitlik Günleri

- **POST** `/api/v1/availableDates` → Yeni müsait gün ekler  
- **PUT** `/api/v1/availableDates/{id}` → Müsait günü günceller  
- **DELETE** `/api/v1/availableDates/{id}` → Müsait günü siler  
- **GET** `/api/v1/availableDates/{id}` → ID ile müsait gün getirir  
- **GET** `/api/v1/availableDates` → Tüm müsait günleri listeler  
- **GET** `/api/v1/availableDates/doctor/{doctorId}` → Doktora ait müsait günleri getirir  

---

### 👤 Müşteri Yönetimi

- **POST** `/api/v1/customers` → Yeni müşteri ekler  
- **PUT** `/api/v1/customers/{id}` → Müşteri bilgilerini günceller  
- **DELETE** `/api/v1/customers/{id}` → Müşteriyi siler  
- **GET** `/api/v1/customers/{id}` → Belirli ID ile müşteri bilgisi getirir  
- **GET** `/api/v1/customers` → Tüm müşterileri listeler  
- **GET** `/api/v1/customers/search?name={name}` → İsimle müşteri arar  
- **GET** `/api/v1/customers/{customerId}/animals` → Müşterinin hayvanlarını getirir  

---

### 🐾 Hayvan Yönetimi

- **POST** `/api/v1/animals` → Yeni hayvan ekler  
- **PUT** `/api/v1/animals/{id}` → Hayvan bilgilerini günceller  
- **DELETE** `/api/v1/animals/{id}` → Hayvanı siler  
- **GET** `/api/v1/animals/{id}` → ID ile hayvan bilgisi getirir  
- **GET** `/api/v1/animals` → Tüm hayvanları listeler  
- **GET** `/api/v1/animals/search?name={name}` → İsimle hayvan arar  

---

### 💉 Aşı Takibi

- **POST** `/api/v1/vaccines` → Yeni aşı ekler  
- **PUT** `/api/v1/vaccines/{id}` → Aşı bilgilerini günceller  
- **DELETE** `/api/v1/vaccines/{id}` → Aşıyı siler  
- **GET** `/api/v1/vaccines/{id}` → ID ile aşı bilgisi getirir  
- **GET** `/api/v1/vaccines` → Tüm aşıları listeler  
- **GET** `/api/v1/vaccines/filter?startDate={start}&endDate={end}` → Tarih aralığına göre filtreleme  
- **GET** `/api/v1/vaccines/animal/{animalId}` → Hayvana ait tüm aşıları getirir  

---

### 📅 Randevu Yönetimi

- **POST** `/api/v1/appointments` → Yeni randevu oluşturur  
- **PUT** `/api/v1/appointments/{id}` → Randevuyu günceller  
- **DELETE** `/api/v1/appointments/{id}` → Randevuyu siler  
- **GET** `/api/v1/appointments/{id}` → ID ile randevu bilgisi getirir  
- **GET** `/api/v1/appointments` → Tüm randevuları listeler  
- **GET** `/api/v1/appointments/search/doctor?doctorId={id}&start={start}&end={end}` → Doktora ve tarih aralığına göre filtreleme  
- **GET** `/api/v1/appointments/search/animal?animalId={id}&start={start}&end={end}` → Hayvana ve tarih aralığına göre filtreleme  

Geliştiren: Burak Tatar
