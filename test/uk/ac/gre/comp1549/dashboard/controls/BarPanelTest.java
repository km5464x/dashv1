/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard.controls;

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
public class BarPanelTest {
    
    public BarPanelTest() {
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
     * Test of setValue method, of class BarPanel.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int value = 0;
        BarPanel instance = new BarPanel();
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLabel method, of class BarPanel.
     */
    @Test
    public void testSetLabel() {
        System.out.println("setLabel");
        String label = "";
        BarPanel instance = new BarPanel();
        instance.setLabel(label);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
