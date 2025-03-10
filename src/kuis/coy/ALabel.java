/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis.coy;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Lab Informatika
 */
public class ALabel extends JLabel{
    public ALabel(String text){
        super(text);
        setFont(new Font("arial", Font.PLAIN, 18));
    } 
    public ALabel(String text, int fontSize){
        super(text);
        setFont(new Font("arial", Font.PLAIN, fontSize));
        
    }
    public ALabel(String text, int fontSize, boolean isBold){
        super(text);
        setFont(new Font("arial", Font.BOLD, fontSize));
        
    }
    
}
