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
public class PetunjukKaryawan {
    public static void main(String[] args) {
       new Data();
    }
}
class Petunjuk extends JFrame implements ActionListener{
    private JLabel judul;
    private JButton btnHome;
    private JButton btnGaji;
    private JButton btnData;
    private JButton btnAdmin;
    private JButton btnPetunjuk;
    
    String[][] data = new String[500][7];
    String[] kolom = {"ID","Nama","Posisi","Gaji Pokok","Jam Lembur","Tunjangan","Total Gaji"};
    JTable tabel;
    JTextArea taPetunjuk;
    JButton bShow;
    JScrollPane scrollPane;
    JPanel panelForm, panelTombol;

    
    public Petunjuk(){
        setTitle("Gaji Karyawan");
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
        
        //petunjuk yang diberikan kepada karyawan
        taPetunjuk = new JTextArea("Klik Tombol Gaji untuk menghitung gaji. Klik tombol data melihat data sudah masuk atau belum");
        add(taPetunjuk);
        taPetunjuk.setBounds(200,70,300,200);
        
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
}