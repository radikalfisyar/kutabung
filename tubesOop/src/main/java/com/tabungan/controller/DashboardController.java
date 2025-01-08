/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tabungan.controller;

import com.tabungan.model.Dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tabungan.utils.ConnectionManager;

public class DashboardController {

    private ConnectionManager conMan;
    
    public DashboardController() {
        this.conMan = new ConnectionManager(); // Inisialisasi koneksi database
    }
    // Metode untuk menambah tabungan
    public boolean tambahTabungan(Dashboard dashboard) {
        String query = "INSERT INTO tabungan (username, nama_tabungan, target_tabungan, total_terkumpul) VALUES (?, ?, ?, ?)";
        try (Connection conn = conMan.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, dashboard.getUsername());
            stmt.setString(2, dashboard.getNamaTabungan());
            stmt.setDouble(3, dashboard.getTargetTabungan());
            stmt.setDouble(4, dashboard.getTotalTerkumpul());
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Mengembalikan false jika gagal
        }
    }

    // Metode untuk mengambil semua tabungan milik pengguna
    public List<Dashboard> ambilSemuaTabungan(String username) {
        String query = "SELECT * FROM tabungan WHERE username = ?";
        List<Dashboard> daftarTabungan = new ArrayList<>();
        try (Connection conn = conMan.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                daftarTabungan.add(new Dashboard(
                        rs.getString("username"),
                        rs.getString("nama_tabungan"),
                        rs.getDouble("target_tabungan"),
                        rs.getDouble("total_terkumpul")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarTabungan; // Mengembalikan daftar tabungan
    }

    // Metode untuk menghapus tabungan
    public boolean hapusTabungan(String namaTabungan) {
        String query = "DELETE FROM tabungan WHERE nama_tabungan = ?";
        try (Connection conn = conMan.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaTabungan);
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil dihapus
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Mengembalikan false jika gagal
        }
    }

    // Metode untuk menambah nominal pada tabungan
    public boolean tambahNominal(String namaTabungan, double jumlah) {
        String query = "UPDATE tabungan SET total_terkumpul = total_terkumpul + ? WHERE nama_tabungan = ?";
        try (Connection conn = conMan.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, jumlah);
            stmt.setString(2, namaTabungan);
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil ditambahkan
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Mengembalikan false jika gagal
        }
    }

    // Metode untuk memperbarui tabungan
    public boolean updateTabungan(String oldNamaTabungan, String newNamaTabungan, double newTargetTabungan) {
        String query = "UPDATE tabungan SET nama_tabungan = ?, target_tabungan = ? WHERE nama_tabungan = ?";
        try (Connection conn = conMan.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newNamaTabungan);
            stmt.setDouble(2, newTargetTabungan);
            stmt.setString(3, oldNamaTabungan);
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil diperbarui
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Mengembalikan false jika gagal
        }
    }
    
    public boolean hapusTabungan(String namaTabungan, String newNamaTabungan) {
    String query = "DELETE FROM akun WHERE nama_tabungan = ?";
    try (Connection conn = conMan.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, namaTabungan);
        stmt.setString(2, newNamaTabungan);
        return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil dihapus
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Mengembalikan false jika gagal
    }
  }
}



