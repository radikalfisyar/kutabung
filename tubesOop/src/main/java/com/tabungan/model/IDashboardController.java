/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tabungan.model;


import com.tabungan.model.Dashboard;
import java.util.List;

public interface IDashboardController {
    boolean tambahTabungan(Dashboard dashboard);
    List<Dashboard> ambilSemuaTabungan(String username);
    boolean hapusTabungan(String namaTabungan);
    boolean tambahNominal(String namaTabungan, double jumlah);
}

    

