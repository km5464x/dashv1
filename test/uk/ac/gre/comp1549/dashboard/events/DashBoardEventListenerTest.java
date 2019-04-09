/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard.events;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Non Family
 */
public class DashBoardEventListenerTest {
    
    public DashBoardEventListenerTest() {
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
     * Test of processDashBoardEvent method, of class DashBoardEventListener.
     */
    @Test
    public void testProcessDashBoardEvent() {
        System.out.println("processDashBoardEvent");
        Object originator = null;
        DashBoardEvent dbe = null;
        DashBoardEventListener instance = new DashBoardEventListenerImpl();
        instance.processDashBoardEvent(originator, dbe);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    public class DashBoardEventListenerImpl implements DashBoardEventListener {

        public void processDashBoardEvent(Object originator, DashBoardEvent dbe) {
        }
    }
    
}
