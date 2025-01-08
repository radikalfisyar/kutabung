/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tabungan.controller;

import com.tabungan.model.Profil; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.tabungan.utils.ConnectionManager;

public class ProfilController {
    private ConnectionManager conMan;

    // Tambah Profil
    public boolean tambahProfil(Profil profil) {
        String query = "INSERT INTO profil (username, nama, email, gender) VALUES (?, ?, ?, ?)";
        try (Connection conn = conMan.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, profil.getUsername());
            stmt.setString(2, profil.getNama());
            stmt.setString(3, profil.getEmail());
            stmt.setString(4, profil.getGender());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cari Profil
    public Profil cariProfil(String username) {
        String query = "SELECT * FROM profil WHERE username = ?";
        try (Connection conn = conMan.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Profil(
                        rs.getString("username"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("gender")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Hapus Profil
    public boolean hapusProfil(String username) {
        String query = "DELETE FROM profil WHERE username = ?";
        try (Connection conn = conMan.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

