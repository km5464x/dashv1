/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard;

import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import uk.ac.gre.comp1549.dashboard.controls.BarPanel;
import uk.ac.gre.comp1549.dashboard.controls.BarPanel2;
import uk.ac.gre.comp1549.dashboard.controls.DialPanel;
import uk.ac.gre.comp1549.dashboard.controls.Digital;
/**
 *
 * @author claud
 */
class Dashboard {
    
    
     private DialPanel speedDial;
    private DialPanel petrolDial;
    private BarPanel petrolBar;
    private BarPanel2 DistanceBar;/////////////// added distance /////////////////
    private DialPanel tempBar;
    private Digital tempDig;
    
     private static Dashboard instance = null;
    
     private Dashboard(Point p2) {
    
    // Set up the dashboard screen        
        JFrame dashboard = new JFrame("Demo dashboard");
        dashboard.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dashboard.setLayout(new FlowLayout());
        
        DistanceBar = new BarPanel2();/////////////////////// Added   distance
        DistanceBar.setLabel("Distance");
        DistanceBar.setValue(100);
        dashboard.add(DistanceBar);
        dashboard.pack();

        // add the speed Dial
        speedDial = new DialPanel();
        speedDial.setLabel("SPEED");
        dashboard.add(speedDial);
       

        // add the petrol Dial
        petrolDial = new DialPanel();
        petrolDial.setLabel("PETROL");
        petrolDial.setValue(100);
        dashboard.add(petrolDial);
        
        tempBar = new DialPanel();
        tempBar.setLabel("Temp");
        dashboard.add(tempBar);
        
        //temp digital
       tempDig= new Digital();
        tempDig.setLabel("Temp");
        tempDig.setLabel("0.0C");
        
        
        dashboard.add(tempDig);
        
        
        // add the petrol Bar
        petrolBar = new BarPanel();
        petrolBar.setLabel("PETROL");
        petrolBar.setValue(100);
        dashboard.add(petrolBar);
        dashboard.pack();
        
      
        
        
      
        
        // centre the dashboard frame above the control frame
        
        
        
          // centre the dashboard frame above the control frame
       
        int hDash = dashboard.getHeight(); // height of dashboard frame 
        int wDash = dashboard.getWidth(); // width of dashboard frame 
        // calculate where top left of the dashboard goes to centre it over the control frame
         Point a2 = new Point((int) p2.getX() - (wDash / 2), (int) p2.getY() - hDash );
        dashboard.setLocation(a2);
        dashboard.setVisible(true);
        
       
        dashboard.setVisible(true);
     }
     
    public static synchronized Dashboard getInstance(Point p2) {
        if (instance == null) {
            instance = new Dashboard(p2);
        }
        return instance;
    }
     
     
     public DialPanel speedDial(){
         return speedDial;     
     }
    public DialPanel petrolDial(){
        return petrolDial;
    }
    public BarPanel petrolBar(){
        return petrolBar;
    }
    public BarPanel2 DistanceBar(){
        return DistanceBar;
    }
    public DialPanel tempBar(){
        return tempBar;
    }
    public Digital tempDig(){
        return tempDig;
    }
     
     
}
