/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard.events;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Non Family
 */
public class DashBoardEventSetup {
    
    public String type; // type of event e.g "speed"
    public String value; // value of the event e.g. "30"
    
    HashMap<String, List<DashBoardEventListener>> eventListeners;
    
    
    
}
