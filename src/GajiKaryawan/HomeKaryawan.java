/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GajiKaryawan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Hp
 */
public class HomeKaryawan {
    public static void main(String[] args) {
        // membuka class untuk menjalankan frame
       new Home();
    }
}

class Home extends JFrame implements ActionListener{
    //deklarasi jframe yang akan digunakan
    private JLabel judul;
    private JButton btnHome;
    private JButton btnGaji;
    private JButton btnData;
    private JButton btnAdmin;
    private JButton btnPetunjuk;
    public Home(){
        //set halaman
        setTitle("Home Karyawan");
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
            new Admin();
        }
    }
}




