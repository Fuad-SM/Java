/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import javax.swing.JOptionPane;

public class Siswa {
public void inputSiswa(String nis, String nisn, String nama, String tempatlahir, String tanggallahir,String jeniskelamin, String alamat){
    try{ 
        Class.forName("com.mysql.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/kartupelajar", "root", "");
        String query = "insert into siswa values (?,?,?,?,?,?,?)";
        PreparedStatement prestat = koneksi.prepareStatement(query);
        prestat.setString(1, nis);
        prestat.setString(2, nisn);
        prestat.setString(3, nama);
        prestat.setString(4, tempatlahir);
        prestat.setString(5, tanggallahir);
        prestat.setString(6, jeniskelamin);
        prestat.setString(7, alamat);
        prestat.executeUpdate();
        koneksi.close();
        }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, "Query Error"+e, "Error",JOptionPane.ERROR_MESSAGE);
    }
    }

public void updateSiswa(String nis, String nisn, String nama, String tempatlahir, String tanggallahir,String jeniskelamin, String alamat){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/rumahsakit", "root", "");
        String query = "update pasien set nisn=?, nama=?, tanggallahir=?, jeniskelamin=?, golongandarah=?, telepon=?, keluhan=? where nik=?";
        PreparedStatement prestat = koneksi.prepareStatement(query);
        prestat.setString(1, nisn);
        prestat.setString(2, nama);
        prestat.setString(3, tempatlahir);
        prestat.setString(4, tanggallahir);
        prestat.setString(5, jeniskelamin);
        prestat.setString(6, alamat);
        prestat.setString(7, nis);
        prestat.executeUpdate();
        koneksi.close();
        }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, "Query Error"+e, "Error",JOptionPane.ERROR_MESSAGE);
    }
    }
}