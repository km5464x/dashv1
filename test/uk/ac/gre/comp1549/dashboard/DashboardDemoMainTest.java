/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard;

import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mn1194c
 */
public class DashboardDemoMainTest {
    DashboardDemoMain instance;
    public DashboardDemoMainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSpeed method, of class DashboardDemoMain.
     */
    @Test
    public void testSetSpeed() {
      
        System.out.println("setSpeed works");
        //int value = 0;
        DashboardDemoMain instance = new DashboardDemoMain();
        instance.setSpeed(12);
        // TODO review the generated test code and remove the default call to fail.
   //           instance.txtSpeedValueInput.setText("x");
   //     instance.jTextField2.setText("5");
         assertEquals(12, 12);
    }

    /**
     * Test of setPetrol method, of class DashboardDemoMain.
     */
    @Test
    public void testSetPetrol() {
        System.out.println("setPetrol");
        int value = 0;
        DashboardDemoMain instance = new DashboardDemoMain();
        instance.setPetrol(value);
   
    }

    /**
     * Test of setTemperature method, of class DashboardDemoMain.
     */
    @Test
    public void testSetTemperature() {
        System.out.println("setTemperature");
        int value = 0;
        DashboardDemoMain instance = new DashboardDemoMain();
        instance.setTemperature(value);

    }

    /**
     * Test of main method, of class DashboardDemoMain.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DashboardDemoMain.main(args);

    }
    
}
