/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tabungan.controller;

import com.tabungan.model.Akun;
import com.tabungan.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AkunController {
    private ConnectionManager conMan;
    private Akun akun; // Variabel untuk menyimpan objek Akun

    // Metode untuk login pengguna
    public boolean login(String username, String password) {
        Connection con = null;
        String query = "SELECT * FROM akun WHERE username = ? AND password = ?";
        try {
            con = conMan.getConnection(); // Mendapatkan koneksi dari DatabaseConnection
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                akun = new Akun(rs.getString("username"), rs.getString("password"));
                return true; // Login berhasil
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close(); // Pastikan koneksi ditutup
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // Login gagal
    }

    // Metode untuk registrasi pengguna
    public boolean register(String username, String password) {
        Connection con = null;
        String query = "INSERT INTO akun (username, password) VALUES (?, ?)";
        try {
            con = conMan.getConnection(); // Mendapatkan koneksi dari DatabaseConnection
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int result = pstmt.executeUpdate(); // Eksekusi pernyataan insert
            return result > 0; // Mengembalikan true jika berhasil ditambahkan
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Mengembalikan false jika gagal
        } finally {
            try {
                if (con != null) {
                    con.close(); // Pastikan koneksi ditutup
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean tambahAkun(Akun akunBaru) {
        String query = "INSERT INTO akun (username, password) VALUES (?, ?)";

        try (Connection conn = conMan.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, akunBaru.getUsername());
            pstmt.setString(2, akunBaru.getPassword());

            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0; // Return true jika proses insert berhasil

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Return false jika gagal
        }
    }

    // Metode untuk mendapatkan objek Akun yang sedang login
    public Akun getAkun() {
        return akun;
    }
}
