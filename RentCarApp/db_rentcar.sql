
CREATE DATABASE db_rentcar;
USE db_rentcar;
CREATE TABLE mobil (id INT AUTO_INCREMENT PRIMARY KEY, plat VARCHAR(15), merk VARCHAR(50), status ENUM('tersedia', 'disewa'));
CREATE TABLE customer (id INT AUTO_INCREMENT PRIMARY KEY, nama VARCHAR(100), alamat TEXT);
CREATE TABLE transaksi (id INT AUTO_INCREMENT PRIMARY KEY, id_mobil INT, id_customer INT, tgl_sewa DATE, tgl_kembali_est DATE, tgl_kembali_aktual DATE, denda INT,
FOREIGN KEY (id_mobil) REFERENCES mobil(id), FOREIGN KEY (id_customer) REFERENCES customer(id));
