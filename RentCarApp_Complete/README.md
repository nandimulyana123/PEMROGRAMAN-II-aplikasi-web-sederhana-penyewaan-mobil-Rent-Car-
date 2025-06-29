# 🚗 RentCarApp – Aplikasi Penyewaan Mobil (JSP & Servlet)

Aplikasi web sederhana untuk mengelola penyewaan mobil menggunakan **Java EE (JSP & Servlet)** dan **MySQL**. Aplikasi ini mendukung fitur input data mobil, customer, transaksi sewa, pengembalian mobil, serta laporan transaksi.

---

## 🧾 Fitur Aplikasi

✅ Manajemen **Data Mobil**  
✅ Manajemen **Data Customer**  
✅ **Transaksi Sewa** dan **Pengembalian Mobil**  
✅ Hitung **denda otomatis** jika telat kembali  
✅ **Laporan Transaksi** berdasarkan histori

---

## 💻 Teknologi yang Digunakan

- Java EE (Servlet & JSP)
- Apache Tomcat (v9 atau v10)
- MySQL Database
- JDBC (Java Database Connectivity)
- HTML/CSS (minimal tampilan)
- NetBeans/Eclipse (IDE)

---

## 🛠️ Cara Menjalankan Proyek

### 1. **Kloning / Unduh Proyek**
```bash
git clone https://github.com/username/RentCarApp.git
```

### 2. **Import ke NetBeans / Eclipse**
- Buka **NetBeans**
- Pilih **File → Open Project**
- Arahkan ke folder `RentCarApp` hasil ekstrak

### 3. **Siapkan Database di MySQL**
Jalankan SQL berikut di phpMyAdmin atau MySQL Workbench:

```sql
CREATE DATABASE db_rentcar;
USE db_rentcar;

CREATE TABLE mobil (
  id INT AUTO_INCREMENT PRIMARY KEY,
  plat VARCHAR(15),
  merk VARCHAR(50),
  status ENUM('tersedia', 'disewa')
);

CREATE TABLE customer (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nama VARCHAR(100),
  alamat TEXT
);

CREATE TABLE transaksi (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_mobil INT,
  id_customer INT,
  tgl_sewa DATE,
  tgl_kembali_est DATE,
  tgl_kembali_aktual DATE,
  denda INT,
  FOREIGN KEY (id_mobil) REFERENCES mobil(id),
  FOREIGN KEY (id_customer) REFERENCES customer(id)
);
```

### 4. **Konfigurasi Koneksi Database**
Edit file DAO seperti `MobilDAO.java`, sesuaikan baris JDBC berikut:
```java
String jdbcURL = "jdbc:mysql://localhost:3306/db_rentcar";
String jdbcUsername = "root";
String jdbcPassword = ""; // sesuaikan dengan password MySQL kamu
```

### 5. **Jalankan Aplikasi**
- Klik kanan proyek → **Run**
- Akses melalui browser:
```
http://localhost:8080/RentCarApp/
```

---

## 📂 Struktur Direktori

```
RentCarApp/
├── WebContent/
│   ├── index.jsp
│   ├── mobil/
│   ├── customer/
│   └── transaksi/
├── src/
│   ├── controller/
│   ├── model/
│   └── dao/
├── db_rentcar.sql
└── WEB-INF/web.xml
```

---

## 📋 Catatan Tambahan

- Tidak menggunakan fitur login untuk versi ini.
- Untuk menambahkan validasi dan fitur lanjutan seperti filter laporan, dapat ditambahkan modul ekstensi.

---

## 🧑‍💻 Kontributor
- **Nama:** (Isikan nama kamu)
- **NIM:** (Jika proyek kuliah)
- **Universitas:** (Jika ada)

---

## ⚖️ Lisensi
Proyek ini hanya untuk pembelajaran dan pengembangan tugas akademik. Bebas digunakan untuk kebutuhan non-komersial.
