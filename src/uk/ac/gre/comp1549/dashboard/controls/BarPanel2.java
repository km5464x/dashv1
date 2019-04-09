/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard.controls;


import java.awt.BorderLayout;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
/**
 *
 * @author Non Family
 */
public class BarPanel2 extends BarPanel {

    private BarPaneldraw2 bar; 
    
  
    
     public BarPanel2() {
        setLayout(new BorderLayout());
        // set the style of the border
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        // position the label above the bar 
        lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        add(lblTitle, BorderLayout.NORTH);
        bar = new BarPaneldraw2();
        add(bar, BorderLayout.CENTER);

    }
    
    public void setValue(int value) {
        bar.setValue(value);
    }
    
}
