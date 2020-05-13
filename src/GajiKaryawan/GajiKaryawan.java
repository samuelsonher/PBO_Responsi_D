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
public class GajiKaryawan {
    // membuka class untuk menjalankan frame
    public static void main(String[] args) {
       new Gaji();
    }
}

class Gaji extends JFrame implements ActionListener{
        //deklarasi jframe yang akan digunakan
    private JLabel judul;
    private JButton btnHome;
    private JButton btnGaji;
    private JButton btnData;
    private JButton btnAdmin;
    private JButton btnPetunjuk;
    
    
    JLabel lID, lNama, lPosisi, lAlamat, lNohp, lGajipokok, lJamlembur, lTunjangan, lPajak, lTotalGaji;
    JTextField tfID, tfNama, tfAlamat, tfNohp, tfGajipokok, tfJamlembur;
    JLabel  ltfTunjangan, ltfPajak, ltfTotalGaji;
    JButton bHitung, bSimpan;
    String[] posisi = {"Direktur","Manager","Programmer","Marketing","Surveyor"};
    JComboBox cmbPosisi = new JComboBox(posisi);
    JPanel panelForm, panelTombol;
    //deklarasi untuk database
    String DBurl = "jdbc:mysql://localhost/gajipegawai";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public Gaji(){
        //set halaman
        setTitle("Gaji Karyawan");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //memberi data/teks pada jframe
        judul = new JLabel("Menu");
        btnHome = new JButton("HOME");
        btnGaji = new JButton("GAJI");
        btnData = new JButton("DATA");
        btnAdmin = new JButton("ADMIN");
        btnPetunjuk = new JButton("PETUNJUK");
        //meng-add actionlistener
        btnHome.addActionListener(this);
        btnGaji.addActionListener(this);
        btnData.addActionListener(this);
        btnAdmin.addActionListener(this);
        btnPetunjuk.addActionListener(this);
        setLayout(null);
        //add jframe pada halaman
        add(judul);
        add(btnHome);
        add(btnGaji);
        add(btnData);
        add(btnAdmin);
        add(btnPetunjuk);
        //men-setting posisi jframe pada halaman
        judul.setBounds(280,10,120,20);
        btnHome.setBounds(20,50,150,40);
        btnGaji.setBounds(20,100,150,40);
        btnData.setBounds(20,150,150,40);
        btnPetunjuk.setBounds(20,200,150,40);
        btnAdmin.setBounds(560,130,150,40);
        
        //deklarasi form pegawai
        lID = new JLabel("ID Pegawai: ");
        lNama = new JLabel("Nama: ");
        lPosisi = new JLabel("Posisi: ");
        lAlamat = new JLabel("Alamat: ");
        lNohp = new JLabel("No HP: ");
        lGajipokok = new JLabel("Gaji Pokok: ");
        lJamlembur = new JLabel("Jam Lembur");
        lTunjangan = new JLabel("Tunjangan");
        lPajak = new JLabel("Pajak");
        lTotalGaji = new JLabel("Total Gaji");
        tfID = new JTextField(9);
        tfNama = new JTextField(50);
        tfAlamat = new JTextField(50);
        tfNohp = new JTextField(50);
        tfGajipokok = new JTextField(50);
        tfJamlembur = new JTextField(50);
        ltfTunjangan = new JLabel(" ");
        ltfPajak = new JLabel(" ");
        ltfTotalGaji = new JLabel(" ");
        bHitung = new JButton("Hitung");
        bSimpan = new JButton("Simpan");
        panelForm = new JPanel(new GridLayout(3, 2));
        panelTombol = new JPanel(new FlowLayout());

        //add ke jframe
        setLayout(new BorderLayout());
        add(panelForm);
        panelForm.add(lID);
        panelForm.add(tfID);
        panelForm.add(lNama);
        panelForm.add(tfNama);
        panelForm.add(lPosisi);
        panelForm.add(cmbPosisi);
        panelForm.add(lAlamat);
        panelForm.add(tfAlamat);
        panelForm.add(lNohp);
        panelForm.add(tfNohp);
        panelForm.add(lGajipokok);
        panelForm.add(tfGajipokok);
        panelForm.add(lJamlembur);
        panelForm.add(tfJamlembur);
        panelForm.add(lTunjangan);
        panelForm.add(ltfTunjangan);
        panelForm.add(lPajak);
        panelForm.add(ltfPajak);
        panelForm.add(lTotalGaji);
        panelForm.add(ltfTotalGaji);
        
        //set posisi jframe
        lID.setBounds(200,50,120,20);
        lNama.setBounds(200,80,120,20);
        lPosisi.setBounds(200,110,120,20);
        lAlamat.setBounds(200,140,120,20);
        lNohp.setBounds(200,170,120,20);
        lGajipokok.setBounds(200,200,120,20);
        lJamlembur.setBounds(200,230,120,20);
        lTunjangan.setBounds(200,260,120,20);
        lPajak.setBounds(200,290,120,20);
        lTotalGaji.setBounds(200,320,120,20);
        tfID.setBounds(350,50,120,20);
        tfNama.setBounds(350,80,120,20);
        cmbPosisi.setBounds(350,110,120,20);
        tfAlamat.setBounds(350,140,120,20);
        tfNohp.setBounds(350,170,120,20);
        tfGajipokok.setBounds(350,200,120,20);
        tfJamlembur.setBounds(350,230,120,20);
        ltfTunjangan.setBounds(350,260,120,20);
        ltfPajak.setBounds(350,290,120,20);
        ltfTotalGaji.setBounds(350,320,120,20);
        
        //tombol button
        add(panelTombol);
        panelTombol.add(bHitung);
        panelTombol.add(bSimpan);
        
        bHitung.setBounds(200,380,70,20);
        bSimpan.setBounds(300,380,70,20);

        //tujuan menekan tombol button
        bHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungData();
            }
        });
        
        bSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                masukkanData();
            }
        });
    }
        
    public void actionPerformed(ActionEvent e) {
        //untuk aksi yang dilakukan setelah menekan tombol button
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
            new HomeA();
        }
    }
    //dari bSimpan, data diproses ke database
    public void masukkanData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("insert into karyawan values("+ tfID.getText() + "," + tfNama.getText() + "," + cmbPosisi.getName()+ "," + tfAlamat.getText() + tfNohp.getText() + "," + tfGajipokok.getText() + "," + tfJamlembur.getText() + "," + ltfTunjangan.getText() + "," + ltfPajak.getText() + "," + ltfTotalGaji.getText() + ")");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    //dari bHitung, data dihitung
    public void hitungData(){
        double gaji = Double.parseDouble(tfGajipokok.getText());
        double jamlbr = Double.parseDouble(tfJamlembur.getText());
        double tunjangan = jamlbr*15000;
        double pajak = gaji/100;
        double totalgaji = gaji - pajak + tunjangan;
        ltfTunjangan.setText(""+tunjangan);
        ltfPajak.setText(""+pajak);
        ltfTotalGaji.setText(""+totalgaji);
    }
}