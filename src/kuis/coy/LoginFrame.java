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
public class LoginFrame extends JFrame {
    private final String CORRECT_USERNAME = "Gradiva", CORRECT_PASSWROD = "123230089";
    public LoginFrame()
    {
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
        
        // Login label
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel loginLabel = new ALabel("Login", 24, true);
        loginLabel.setFont(new Font("arial", Font.BOLD, 20));
        panel.add(loginLabel, gbc);
        
        // username
        gbc.gridy++;
        panel.add(new ALabel("Username: "), gbc);
        gbc.gridx = 1;
        username_field = new JTextField(15);
        panel.add(username_field, gbc);
        
        // password
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new ALabel("Password: "), gbc);
        gbc.gridx = 1;
        password_field = new JPasswordField(15);
        panel.add(password_field, gbc);
        
        gbc.gridy++;
        gbc.gridx = 1;
        loginButton = new JButton("Login");
        panel.add(loginButton, gbc);
        gbc.gridx = 0;
        resetButton = new JButton("Reset");
        panel.add(resetButton, gbc);
        
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction();
            }
        
        });
        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAction();
                
                
            }
        
        });
        
        
        
        add(panel);
    }
    private boolean validateLogin(String username, String password) throws Exception{
        
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWROD)){
            return true;
        }
        throw new Exception("Username atau password salah!");
    }
    
    private void loginAction(){
        String req_username = username_field.getText();
        String req_password = new String(password_field.getPassword());
        
        try{
            validateLogin(req_username, req_password);
            new MainFrame(req_username);
            this.dispose();
            // Pindah screen
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Login gagal: " + ex.getMessage(), "Login gagal", JOptionPane.CANCEL_OPTION);
        }
        
    }
    private void resetAction(){
        username_field.setText("");
        password_field.setText("");
    }
    private JTextField username_field;
    private JPasswordField password_field;
    private JButton loginButton, resetButton;
}
