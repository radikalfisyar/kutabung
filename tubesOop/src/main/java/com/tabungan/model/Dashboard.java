/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tabungan.model;

/**
 *
 * @author radik
 */
public class Dashboard {
    private String username; // Referensi ke tabel Akun
    private String namaTabungan; // Nama tabungan
    private double targetTabungan; // Target jumlah tabungan
    private double totalTerkumpul; // Total jumlah yang telah dikumpulkan

    // Konstruktor
    public Dashboard(String username, String namaTabungan, double targetTabungan, double totalTerkumpul) {
        this.username = username;
        this.namaTabungan = namaTabungan;
        this.targetTabungan = targetTabungan;
        this.totalTerkumpul = totalTerkumpul;
    }

    // Getter dan Setter untuk username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter dan Setter untuk namaTabungan
    public String getNamaTabungan() {
        return namaTabungan;
    }

    public void setNamaTabungan(String namaTabungan) {
        this.namaTabungan = namaTabungan;
    }

    // Getter dan Setter untuk targetTabungan
    public double getTargetTabungan() {
        return targetTabungan;
    }

    public void setTargetTabungan(double targetTabungan) {
        this.targetTabungan = targetTabungan;
    }

    // Getter dan Setter untuk totalTerkumpul
    public double getTotalTerkumpul() {
        return totalTerkumpul;
    }

    public void setTotalTerkumpul(double totalTerkumpul) {
        this.totalTerkumpul = totalTerkumpul;
    }

    // Metode untuk menambah nominal ke total terkumpul
    public void tambahNominal(double jumlah) {
        if (totalTerkumpul + jumlah <= targetTabungan) {
            this.totalTerkumpul += jumlah; // Menambahkan jumlah ke total terkumpul
        } else {
            System.out.println("Jumlah telah melebihi Target.");
        }
    }

    // Metode untuk mengecek apakah target sudah tercapai
    public boolean isTargetTercapai() {
        return totalTerkumpul >= targetTabungan; // Mengembalikan true jika total terkumpul mencapai atau melebihi target
    }
}


    

