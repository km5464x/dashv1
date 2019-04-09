/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard.controls;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Non Family
 */
public class BarPaneldraw2 extends BarDrawPanel {

    public BarPaneldraw2() {
        this(25, 200, 40, 100, 0);
        
    }

    /**
     *
     * @param length - length of the horizontal bar
     * @param height - height of the bar
     * @param padding - padding around the bar
     * @param barMaxValue - bar runs from 0 to barMaxValue
     * @param value - current value that will be indicated on the bar
     */
    
    
    public BarPaneldraw2(int length, int height, int padding, int barMaxValue, int value) {
        // set size of the JPanel to be big enough to hold the bar plus padding
        setPreferredSize(new Dimension(length + (2 * padding), height + (2 * padding)));

        this.barLength = length;
        this.barHeight = height;
        this.padding = padding;
        this.barMaxValue = barMaxValue;
        this.value = value;
    }

  
    /**
     * This method is called every time the Bar needs drawing for instance
     * when the value has changed.  It draws the bar itself and the indicator in the
     * correct position to indicate the current value
     * @param g - graphics object used to draw on the JPanel
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // get a Graphics2D object to draw with
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the bar itself.   The first 10% of the bar is red.  The last 30% is yellow.  Between 10% and 30% 
        // the colour graduates from red to yellow.   Check the API documentation for GradientPaint to see
        // how this works. // added getheight 
        Rectangle2D barx = new Rectangle2D.Double(padding, padding, barLength, barHeight);
        GradientPaint redtoyellow = new GradientPaint(0 + (float) barx.getHeight() * 0.1F, 0, Color.LIGHT_GRAY, (float) barx.getHeight() * 0.3F, 0, Color.DARK_GRAY);
        g2.setPaint(redtoyellow);
        g2.fill(barx);

        // draw the value indicator to show the current value
       g2.setStroke(new BasicStroke(barLength/1, BasicStroke.JOIN_ROUND, 0));
        g2.setPaint(Color.LIGHT_GRAY);
        Line2D valueIndicator = new Line2D.Double(barLength +(padding / 1.5F),padding + (barHeight * value / barMaxValue),barLength + (padding / 1.5F),(barHeight * value / barMaxValue));//neww
        //Line2D valueIndicator = new Line2D.Double( barHeight + (padding * 1.5F),padding + (barHeight * value / barMaxValue), barLength  , barHeight + (padding * 1.5F));
        //Line2D valueIndicator = new Line2D.Double(padding + (barLength * value / barMaxValue), padding/2F, padding + (barLength * value / barMaxValue), barHeight + (padding * 1.5F));
       //Line2D valueIndicator = new Line2D.Double(barHeight + ,barLength,barHeight,barLength);
       g2.draw(valueIndicator);
    }
}
