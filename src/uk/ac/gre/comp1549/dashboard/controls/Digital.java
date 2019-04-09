/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard.controls;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author claud
 */
public class Digital extends JPanel{
   
    
    
  


/**
 * DialPanel.  Container for DialDrawPanel to hold dial and label.
 * If a label is not needed DialDrawPanel an be used on its own
 *
 * @author COMP1549
 * @version 2.0
 */


  
    private JLabel lblTitle; // the label which always appears above the dial
    private JLabel temp;
    
    /**
     * Default constructor
     */
    public Digital() {
        setLayout(new BorderLayout());
        
        // set the style of the border
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        // position the label above the dial
        lblTitle = new JLabel();
        lblTitle.setFont(new Font("Arial",Font.PLAIN,50));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        add(lblTitle, BorderLayout.NORTH);
        temp = new JLabel();
        add(temp, BorderLayout.CENTER);
            
        
        
    }

    /**
     * Set the value for the digital
     * @param value - value for the digital
     */
    public void setValue(int value) {
        String text = Integer.toString(value)+"C`";
        lblTitle.setText(text);
       
    }

    /**
     *
     * @param label - label to appear above the digital
     */
    public void setLabel(String label) {
        lblTitle.setText(label);
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



