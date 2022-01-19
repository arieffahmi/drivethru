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
public class CarSortByMakeModel implements Comparator<Car>{
    
    public int compare(Car c, Car c2) {
       
       String car1 = c.getMake() + " " + c.getModel();
       String car2 = c2.getMake() + " " + c2.getModel();
        
       return (car1.compareTo(car2));
    }     
}
