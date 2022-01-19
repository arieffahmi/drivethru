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
public class Car {
    private String registration;
    private String make;
    private String model;
    private String transmission;
    private double rate;
    private String currentStuID;
    private boolean bookStatus;
    
    public Car() {
        registration = "";
        make = "";
        model = "";
        transmission = "";
        rate = 0.0;
        currentStuID = "";
        bookStatus = false;
    }

    public Car(String registration, String make, String model, String transmission, double rate, String currentStuID, boolean bookStatus) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.transmission = transmission;
        this.rate = rate;
        this.currentStuID = currentStuID;
        this.bookStatus = bookStatus;
    }

    public String getRegistration() {
        return registration;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getTransmission() {
        return transmission;
    }
    
    public double getRate() {
        return rate;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getCurStuID() {
        return currentStuID;
    }

    public void setCurStuID(String curStuID) {
        this.currentStuID = curStuID;
    }
    
    public String displayTransmission(){
        if (getTransmission().equalsIgnoreCase("a"))
            return "Automatic";
        else return "Manual";
    }

    public boolean getBookStatus(){
        return bookStatus;
    } 
    
}
