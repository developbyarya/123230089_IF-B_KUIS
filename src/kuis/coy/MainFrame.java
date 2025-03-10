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
public class MainFrame extends JFrame{
    private String nama;
    public MainFrame(String nama){
        this.nama = nama;
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
        
        panel.add(new ALabel("Selamat datang, " + nama, 18, true), gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new ALabel("Apel (Rp. 15.000/kg)"), gbc);
        gbc.gridx = 1;
        apelField = new JTextField(15);
        panel.add(apelField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new ALabel("Jeruk (Rp. 12.000/kg)"), gbc);
        gbc.gridx = 1;
        jerukField = new JTextField(15);
        panel.add(jerukField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new ALabel("Mangga (Rp. 20.000/kg)"), gbc);
        gbc.gridx = 1;
        manggaField = new JTextField(15);
        panel.add(manggaField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        beliButton = new JButton("Beli");
        logoutButton = new JButton("Logout");
        panel.add(logoutButton, gbc);
        gbc.gridx = 1;
        panel.add(beliButton, gbc);
        
        logoutButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutAction();
            }
        });
         beliButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                beliAction();
            }
        });


        //
        add(panel);
    }
    
    private void beliAction(){
        try {
            int jmlhApel = Integer.parseInt(apelField.getText());
            int jmlhJeruk = Integer.parseInt(jerukField.getText());
            int jmlhMangga = Integer.parseInt(manggaField.getText());
            
            new PembelianFrame(jmlhApel, jmlhJeruk, jmlhMangga, nama);
            this.dispose();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Gagal: pastikan semua input adalah angka", "Error", JOptionPane.CANCEL_OPTION);
        }
    }
    
    private void logoutAction(){
        new LoginFrame();
        this.dispose();
    }
    
    private  JTextField apelField, jerukField, manggaField;
    private JButton beliButton, logoutButton;
}
