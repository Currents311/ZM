package com.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sesi {

    private static int idKaryawan; // Tambahkan variabel idKaryawan
    private static String namaKaryawan;
    private static String role;
    private static final Connection conn = Koneks.getConnection(); // Gunakan final karena seharusnya tidak berubah

    public static int getIdKaryawan() {
        return idKaryawan;
    }

    public static void setIdKaryawan(int id) {
        idKaryawan = id; // Simpan id karyawan yang login
    }

    public static String getNamaKaryawan() {
        return namaKaryawan;
    }

    public static void setNamaKaryawan(String nama) {
        namaKaryawan = nama; // Simpan nama karyawan yang login
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String r) {
        role = r;
    }

    public static List<String> getSupplierList() {
        List<String> suppliers = new ArrayList<>();
        String sql = "SELECT nama_supplier FROM supplier";
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(sql); // Gunakan conn yang sudah diinisialisasi di atas
            rs = st.executeQuery();
            
            while (rs.next()) {
                suppliers.add(rs.getString("nama_supplier"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return suppliers;
    }
    
    public static List<String> getPembelianList() {
    List<String> pembelianList = new ArrayList<>();
    String sql = "SELECT id_pembelian FROM pembelian";
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        
        while (rs.next()) {
            pembelianList.add(String.valueOf(rs.getInt("id_pembelian")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return pembelianList;
}

}

