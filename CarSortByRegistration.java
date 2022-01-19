/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivethru;

import java.util.Comparator;

/**
 *
 * @author Arief Fahmi
 */
public class CarSortByRegistration implements Comparator<Car>{
    
    public int compare(Car c, Car c2) {
       return c.getRegistration().compareTo(c2.getRegistration());
    }     
}
