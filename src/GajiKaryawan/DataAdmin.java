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
public class DataAdmin {
    public static void main(String[] args) {
       new DataA();
    }
}
class DataA extends JFrame implements ActionListener{
    private JLabel judul;
    private JButton btnHome;
    private JButton btnGaji;
    private JButton btnData;
    private JButton btnAdmin;
    private JButton btnPetunjuk;
    
    String[][] data = new String[500][7];
    String[] kolom = {"ID","Nama","Alamat","No HP","Posisi","Gaji Pokok"};
    JTable tabel;
    JButton bShow;
    JScrollPane scrollPane;
    JPanel panelForm, panelTombol;
    String DBurl = "jdbc:mysql://localhost/gajipegawai";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public DataA(){
        setTitle("Gaji Karyawan");
        setSize(400,300);
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
        judul.setBounds(190,10,120,20);
        btnHome.setBounds(130,50,150,20);
        btnGaji.setBounds(130,90,150,20);
        btnData.setBounds(130,130,150,20);
        btnAdmin.setBounds(130,130,150,20);
        btnPetunjuk.setBounds(130,130,150,20);
        
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);

        setLayout(new FlowLayout());
        add(panelForm, BorderLayout.CENTER);
        panelForm.add(scrollPane);
        add(panelTombol, BorderLayout.SOUTH);
        panelForm.add(bShow);
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
    
    public void tampilData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            statement = koneksi.createStatement();
            String sql = "select id,nama,alamat,nohp,posisi,gajipokok from dataadmin";
            resultSet = statement.executeQuery(sql);
            int p = 0;
            while (resultSet.next()){
                data[p][0] = resultSet.getString("nim");
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("alamat");
                data[p][3] = resultSet.getString("alamat");
                data[p][4] = resultSet.getString("alamat");
                data[p][5] = resultSet.getString("alamat");
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