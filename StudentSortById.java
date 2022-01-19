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
public class StudentSortById implements Comparator<Student>{
    public int compare(Student s, Student s2){   
        return s.getID().compareTo(s2.getID()); 
    }      
}
