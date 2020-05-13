/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GajiKaryawan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Hp
 */
public class TambahAdmin {
    public static void main(String[] args) {
       new Tambah();
    }
}

class Tambah extends JFrame implements ActionListener{
    private JLabel judul;
    private JButton btnHome;
    private JButton btnGaji;
    private JButton btnData;
    private JButton btnKaryawan;    
    
    JLabel lID, lNama, lPosisi, lAlamat, lNohp, lGajipokok;
    JTextField tfID, tfNama, tfAlamat, tfNohp, tfGajipokok, tfPosisi;
    JButton bSimpan;
    JPanel panelForm, panelTombol;
    String DBurl = "jdbc:mysql://localhost/gajipegawai";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public Tambah(){
        setTitle("Gaji Karyawan");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        judul = new JLabel("Menu");
        btnHome = new JButton("HOME");
        btnGaji = new JButton("GAJI");
        btnData = new JButton("DATA");
        btnKaryawan = new JButton("KARYAWAN");
        btnHome.addActionListener(this);
        btnGaji.addActionListener(this);
        btnData.addActionListener(this);
        btnKaryawan.addActionListener(this);
        setLayout(null);
        add(judul);
        add(btnHome);
        add(btnGaji);
        add(btnData);
        add(btnKaryawan);
        judul.setBounds(190,10,120,20);
        btnHome.setBounds(130,50,150,20);
        btnGaji.setBounds(130,90,150,20);
        btnData.setBounds(130,130,150,20);
        btnKaryawan.setBounds(130,130,150,20);
        
        lID = new JLabel("ID Pegawai: ");
        lNama = new JLabel("Nama: ");
        lPosisi = new JLabel("Posisi: ");
        lAlamat = new JLabel("Alamat: ");
        lNohp = new JLabel("No HP: ");
        lGajipokok = new JLabel("Gaji Pokok: ");
        tfID = new JTextField(9);
        tfNama = new JTextField(50);
        tfAlamat = new JTextField(50);
        tfNohp = new JTextField(50);
        tfGajipokok = new JTextField(50);
        bSimpan = new JButton("Simpan");
        panelForm = new JPanel(new GridLayout(3, 2));
        panelTombol = new JPanel(new FlowLayout());

        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.CENTER);
        panelForm.add(lID);
        panelForm.add(tfID);
        panelForm.add(lNama);
        panelForm.add(tfNama);
        panelForm.add(lPosisi);
        panelForm.add(lAlamat);
        panelForm.add(tfAlamat);
        panelForm.add(lNohp);
        panelForm.add(tfNohp);
        panelForm.add(lGajipokok);
        panelForm.add(tfGajipokok);
        
        add(panelTombol, BorderLayout.SOUTH);
        panelTombol.add(bSimpan);
        
        bSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });
    }
        
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnHome) {
            new HomeA();
        }
       if (e.getSource()==btnGaji) {
            new Tambah();
        }
       if (e.getSource()==btnData) {
            new DataA();
        }
       if (e.getSource()==btnKaryawan) {
            new Home();
        }
    }
    
    public void simpanData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("insert into dataadmin values("+ tfID.getText() + "," + tfNama.getText() + "," + tfPosisi.getText()+ "," + tfAlamat.getText() + tfNohp.getText() + "," + tfGajipokok.getText() +  ")");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
}