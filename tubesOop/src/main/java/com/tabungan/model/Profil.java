/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tabungan.model;

/**
 *
 * @author radik
 */
public class Profil {
    private String username; // Referensi ke tabel Akun
    private String nama;
    private String email;
    private String gender; // 'L' untuk Laki-laki, 'P' untuk Perempuan

    // Constructor
    public Profil(String username, String nama, String email, String gender) {
        this.username = username;
        this.nama = nama;
        this.email = email;
        this.gender = gender;
    }

    // Getter dan Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("L") || gender.equalsIgnoreCase("P")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Gender harus 'L' atau 'P'.");
        }
    }
}

    

