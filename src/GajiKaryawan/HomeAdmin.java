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
public class HomeAdmin {
    public static void main(String[] args) {
       new HomeA();
    }
}

class HomeA extends JFrame implements ActionListener{
    private JLabel judul;
    private JButton btnHome;
    private JButton btnGaji;
    private JButton btnData;
    private JButton btnAdmin;
    private JButton btnPetunjuk;
    public HomeA(){
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
        setSize(400,300);
        judul.setBounds(190,10,120,20);
        btnHome.setBounds(130,50,150,20);
        btnGaji.setBounds(130,90,150,20);
        btnData.setBounds(130,130,150,20);
        btnAdmin.setBounds(130,130,150,20);
        btnPetunjuk.setBounds(130,130,150,20);
        setVisible(true);
        
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