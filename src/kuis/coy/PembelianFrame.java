/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis.coy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lab Informatika
 */
public class PembelianFrame extends JFrame{
    private int jmlhApel, jmlhJeruk, jmlhMangga;
    private final int hargaApel = 15000, hargaJeruk = 12000, hargaMangga = 20000;
    private final double taxFactor = 0.1;
    private double totalBeforeTax, totalAfterTax, taxTotal;
    private String nama;
    public PembelianFrame(int jmlhApel, int jmlhJeruk, int jmlhMangga, String nama){
        this.nama = nama;
        this.jmlhApel = jmlhApel;
        this.jmlhMangga = jmlhMangga;
        this.jmlhJeruk = jmlhJeruk;
        this.totalBeforeTax = jmlhApel*hargaApel + jmlhJeruk*hargaJeruk + jmlhMangga*hargaMangga;
        this.taxTotal = this.totalBeforeTax * taxFactor;
        this.totalAfterTax = totalBeforeTax + taxTotal;
        setTitle("Login Frame");
        setSize(500, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        generateComponents();
        setVisible(true);
        
    }
    private void generateComponents(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        panel.add(new ALabel("Total", 24, true), gbc);
        
        gbc.gridy++;
        panel.add(new ALabel("Apel: %s Kg x Rp. %s = Rp. %s".formatted(jmlhApel, hargaApel, jmlhApel*hargaApel)), gbc);
        
        gbc.gridy++;
        panel.add(new ALabel("Jeruk: %s Kg x Rp. %s = Rp. %s".formatted(jmlhJeruk, hargaJeruk, jmlhJeruk*hargaJeruk)), gbc);
        
        gbc.gridy++;
        panel.add(new ALabel("Mangga: %s Kg x Rp. %s = Rp. %s".formatted(jmlhMangga, hargaMangga, jmlhMangga*hargaMangga)), gbc);
        
        gbc.gridy++;
        
        JPanel totalPanel = new JPanel(new GridBagLayout());
        totalPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
       
        
        panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0,0));
        totalPanel.add(new ALabel("Subtotal: Rp. " + totalBeforeTax, 18), gbc);
        gbc.gridy++;

        totalPanel.add(new ALabel("Pajak (10%): Rp. " + taxTotal, 18), gbc);
        gbc.gridy++;

        totalPanel.add(new ALabel("Total Harga: Rp. " + totalAfterTax, 18), gbc);        
        gbc.gridy++;
        
        btnKembali = new JButton("Kembali");
        btnKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                kembaliAction();
            }
        });
        totalPanel.add(btnKembali, gbc);
        
        
        
        
        add(panel, BorderLayout.NORTH);
        add(totalPanel, BorderLayout.SOUTH);
    }
    
    private void kembaliAction(){
        new MainFrame(nama);
        
        this.dispose();
    }
    
    private JButton btnKembali;
    
}
