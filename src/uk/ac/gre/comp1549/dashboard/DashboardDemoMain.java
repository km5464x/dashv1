package uk.ac.gre.comp1549.dashboard;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import uk.ac.gre.comp1549.dashboard.controls.BarPanel;
import uk.ac.gre.comp1549.dashboard.controls.BarPanel2;
import uk.ac.gre.comp1549.dashboard.controls.BarPaneldraw2;
import uk.ac.gre.comp1549.dashboard.controls.DialPanel;

import uk.ac.gre.comp1549.dashboard.events.*;
import uk.ac.gre.comp1549.dashboard.scriptreader.DashboardEventGeneratorFromXML;

/**
 * DashboardDemoMain.java Contains the main method for the Dashboard demo
 * application. It: a) provides the controller screen which allows user input
 * which is passed to the display indicators, b) allows the user to run the XML
 * script which changes indicator values, c) creates the dashboard JFrame and
 * adds display indicators to it.
 *
 * @author COMP1549
 * @version 2.0
 */
public class DashboardDemoMain extends JFrame {

    /**     * Name of the XML script file - change here if you want to use a different
     * filename
     */
    public static final String XML_SCRIPT = "dashboard_script.xml";

    // fields that appear on the control panel
     private JTextField txtTrainTypeInput;
    private JTextField txtSpeedValueInput;
    private JTextField txtPetrolValueInput;
    private JTextField txtTemperatureInput;
    private JButton btnScript;

    // fields that appear on the dashboard itself
  /*  private DialPanel speedDial;
    private DialPanel petrolDial;
    private BarPanel petrolBar;
    private BarPanel2 DistanceBar;/////////////// added distance /////////////////
    private DialPanel tempBar;*/
    
    private Dashboard dash;
    /**
     * Constructor. Does maybe more work than is good for a constructor.
     */
    public DashboardDemoMain() {
        // Set up the frame for the controller
        setTitle("Dashboard demonstration controller");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Train typer"));
        txtTrainTypeInput = new JTextField("", 3);
        panel.add(txtTrainTypeInput);
        DocumentListener TrainTypeListener = new TrainTypeListener();
        txtTrainTypeInput.getDocument().addDocumentListener(TrainTypeListener);
       
        panel.add(new JLabel("Speed Value:"));
        txtSpeedValueInput = new JTextField("", 3);
        panel.add(txtSpeedValueInput);
        DocumentListener speedListener = new SpeedValueListener();
        txtSpeedValueInput.getDocument().addDocumentListener(speedListener);
        
        panel.add(new JLabel("Temperature:"));
        txtTemperatureInput = new JTextField("", 3);
        panel.add(txtTemperatureInput);
        DocumentListener TempListener = new TemperatureValueListener();
        txtTemperatureInput.getDocument().addDocumentListener(TempListener);
        
        panel.add(new JLabel("Petrol Value:"));
        txtPetrolValueInput = new JTextField("", 3);
        panel.add(txtPetrolValueInput);
        DocumentListener petrolListener = new PetrolValueListener();
        txtPetrolValueInput.getDocument().addDocumentListener(petrolListener);
        btnScript = new JButton("Start Engine");

        // When the button is read the XML script will be run
        btnScript.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread() {
                    public void run() {
                        
                        //request speed ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        
                        runXMLScript();
                    }
                }.start();
            }
        });
        panel.add(btnScript);
        add(panel);
        pack();

        setLocationRelativeTo(null); // display in centre of screen
        this.setVisible(true);

      
      
        
        
        //create new dash
        //tells it where self(controler) is located
        Point topLeft = this.getLocationOnScreen(); // top left of control frame (this)
        int hControl = this.getHeight(); // height of control frame (this)
        int wControl = this.getWidth(); // width of control frame (this)
       
        // calculate where top left of the dashboard goes to centre it over the control frame
        Point p2 = new Point((int) topLeft.getX() + (wControl / 2), (int) topLeft.getY() - hControl);
        dash =  Dashboard.getInstance(p2);
        
        
    }

    /**
     * Run the XML script file which generates events for the dashboard
     * indicators
     */
    private void runXMLScript() {
        try {
            DashboardEventGeneratorFromXML dbegXML = new DashboardEventGeneratorFromXML(100);

            // Register for speed events from the XML script file
            DashBoardEventListener dbelSpeed = new DashBoardEventListener() {
                @Override
                public void processDashBoardEvent(Object originator, DashBoardEvent dbe) {
                    setSpeed(Integer.parseInt(dbe.getValue()));
                }
            };
            dbegXML.registerDashBoardEventListener("speed", dbelSpeed);

            // Register for petrol events from the XML script file
            DashBoardEventListener dbelPetril = new DashBoardEventListener() {
                @Override
                public void processDashBoardEvent(Object originator, DashBoardEvent dbe) {
                   setPetrol(Integer.parseInt(dbe.getValue()));
                   
                    
                  //  DistanceBar.setValue(Integer.parseInt(dbe.getValue()));//////////////////////remove
                }
            };
            dbegXML.registerDashBoardEventListener("petrol", dbelPetril);
            
            DashBoardEventListener dbelDistance = new DashBoardEventListener() {////newwwwwwwwwwwwwwwwwwwwwww
                @Override
                public void processDashBoardEvent(Object originator, DashBoardEvent dbe) {
                   
                    dash.DistanceBar().setValue(Integer.parseInt(dbe.getValue()));
                    setTemperature(Integer.parseInt(dbe.getValue()));
                }
            };
               dbegXML.registerDashBoardEventListener("distance", dbelDistance);
               
            // Process the script file - it willgenerate events as it runs
            dbegXML.processScriptFile(XML_SCRIPT);

        } catch (Exception ex) {
            Logger.getLogger(DashboardDemoMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Set the speed value to the value entered in the textfield.
     */
    public void setSpeed(int value) {
        try {
    
           
            dash.speedDial().setValue(value);
        } catch (NumberFormatException e) {
        }
        // don't set the speed if the input can't be parsed
    }

    /**
     * Set the petrol value to the value entered in the textfield.
     */
    public void setPetrol(int value) {
        try {
            
            dash.petrolDial().setValue(value);
            dash.petrolBar().setValue(value);
            
           
        } catch (NumberFormatException e) {
        }
        // don't set the speed if the input can't be parsed
    }
        public void setTemperature(int value) {/// added for input temp value to move dial
        try {
            
            dash.tempBar().setValue(value);
            dash.tempDig().setValue(value);
           
           
        } catch (NumberFormatException e) {
             System.out.println("Error occurred");
        }
    
        // don't set the speed if the input can't be parsed
    }
 /*   public void setDistance() {//////////////////new//////////////////////////////////////
        try {
            int value = Integer.parseInt(txtDistanceValueInput.getText().trim());
           
            DistanceBar.setValue(value);////////////////////
        } catch (NumberFormatException e) {
        }
        // don't set the speed if the input can't be parsed
    }*/
    /**
     * Respond to user input in the Speed textfield
     */
             
             private class TrainTypeListener implements DocumentListener {///////////////////////////////////////////////////////////

        @Override//
        public void insertUpdate(DocumentEvent event) {
             if(txtSpeedValueInput.getText().trim()==null){}else{
            int value = Integer.parseInt(txtSpeedValueInput.getText().trim());
            setSpeed(value);
        }
        }

        @Override
        public void removeUpdate(DocumentEvent event) {
            
            if(txtSpeedValueInput.getText().trim()==null){}else{
            int value = Integer.parseInt(txtSpeedValueInput.getText().trim());
            setSpeed(value);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent event) {
        }
    }
             
             
             
    private class SpeedValueListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent event) {
             if(txtSpeedValueInput.getText().trim()==null){}else{
            int value = Integer.parseInt(txtSpeedValueInput.getText().trim());
            setSpeed(value);
        }
        }

        @Override
        public void removeUpdate(DocumentEvent event) {
            
            if(txtSpeedValueInput.getText().trim()==null){}else{
            int value = Integer.parseInt(txtSpeedValueInput.getText().trim());
            setSpeed(value);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent event) {
        }
    }

    /**
     * Respond to user input in the Petrol textfield
     */
    private class PetrolValueListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent event) {
            int value = Integer.parseInt(txtPetrolValueInput.getText().trim());//new
            setPetrol(value);//edit
        }

        @Override
        public void removeUpdate(DocumentEvent event) {
            int value = Integer.parseInt(txtPetrolValueInput.getText().trim());//new
            setPetrol(value);//edit
        }

        @Override
        public void changedUpdate(DocumentEvent event) {
        }
    }
        private class TemperatureValueListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent event) {
            int value = Integer.parseInt(txtTemperatureInput.getText().trim());
            setTemperature(value);
        }

        @Override
        public void removeUpdate(DocumentEvent event) {
            int value = Integer.parseInt(txtTemperatureInput.getText().trim());
            setTemperature(value);
        }

        @Override
        public void changedUpdate(DocumentEvent event) {
        }
    }

    /**
     *
     * @param args - unused
     */
    public static void main(String[] args) {
        final DashboardDemoMain me = new DashboardDemoMain();
    }
}
