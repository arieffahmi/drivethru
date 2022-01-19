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
public class Student {
    
    private String id;
    private String name;
    private String phone;
    private String curCarReg;
    private boolean bookStatus;
    
    Student(){
        id = "";
        name = "";
        phone = "";
        curCarReg = "";
        bookStatus = false;
    }
    
    Student(String id, String name, String phone, String curCarReg, boolean bookStatus){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.curCarReg = curCarReg;
        this.bookStatus = bookStatus;
    }
    
    
    
    public String getID(){return id;}
    public String getName(){return name;}
    public String getPhone(){return phone;}

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getCurCarReg() {
        return curCarReg;
    }

    public void setCurCarReg(String curCarReg) {
        this.curCarReg = curCarReg;
    }
    
    public boolean getBookStatus() {
        return bookStatus;
    }   
    
}
