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
public class DataKaryawan {
    public static void main(String[] args) {
       new Data();
    }
}
class Data extends JFrame implements ActionListener{
    private JLabel judul;
    private JButton btnHome;
    private JButton btnGaji;
    private JButton btnData;
    private JButton btnAdmin;
    private JButton btnPetunjuk;
    
    // deklarasi variabel tabel
    String[][] data = new String[500][7];
    String[] kolom = {"ID","Nama","Posisi","Gaji Pokok","Jam Lembur","Tunjangan","Total Gaji"};
    JTable tabel;
    JButton bShow;
    JScrollPane scrollPane;
    
    JPanel panelForm, panelTombol;
    
    //deklarasi variabel untuk akses database
    String DBurl = "jdbc:mysql://localhost/gajipegawai";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public Data(){
        setTitle(" Karyawan");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        setLocationRelativeTo(null);
        judul = new JLabel("Menu");
        btnHome = new JButton("HOME");
        btnGaji = new JButton("GAJI");
        btnData = new JButton("DATA");
        btnAdmin = new JButton("ADMIN");
        btnPetunjuk = new JButton("PETUNJUK");
        btnHome.addActionListener(this);
        btnGaji.addActionListener(this);
        btnData.addActionListener(this);
        btnAdmin.addActionListener(this);
        btnPetunjuk.addActionListener(this);
        setLayout(null);
        add(judul);
        add(btnHome);
        add(btnGaji);
        add(btnData);
        add(btnAdmin);
        add(btnPetunjuk);
        judul.setBounds(280,10,120,20);
        btnHome.setBounds(20,50,150,40);
        btnGaji.setBounds(20,100,150,40);
        btnData.setBounds(20,150,150,40);
        btnPetunjuk.setBounds(20,200,150,40);
        btnAdmin.setBounds(560,130,150,40);
        
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);

        //menampilkan tabel berisi data karyawan
        setLayout(new FlowLayout());
        add(panelForm);
        panelForm.add(scrollPane);
        scrollPane.setBounds(200,50,700,500);
        add(panelTombol);
        panelForm.add(bShow);
        bShow.setBounds(200,570,70,20);
        pack();
        
    }
        
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnHome) {
            new Home();
        }
       if (e.getSource()==btnGaji) {
            new Gaji();
        }
       if (e.getSource()==btnData) {
            new Data();
        }
       if (e.getSource()==btnPetunjuk) {
            new Petunjuk();
        }
       if (e.getSource()==btnAdmin) {
            new Admin();
        }
    }
    //mengambil data dari database setelah menekan tombol bShow
    public void tampilData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            statement = koneksi.createStatement();
            String sql = "select id,nama,posisi,gajipokok,jamlembur,tunjangan,totalgaji from karyawan";
            resultSet = statement.executeQuery(sql);
            int p = 0;
            while (resultSet.next()){
                data[p][0] = resultSet.getString("nim");
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("alamat");
                p++;
            }
            statement.close();
            koneksi.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
}