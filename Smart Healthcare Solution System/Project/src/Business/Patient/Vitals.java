/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

/**
 *
 * @author haroonperveez
 */
public class Vitals {
    
    private double temperature;
    private int pulse;
    private int insulinLevel;
    private int cholestrol;
    private int bphigh;
    private int bplow;
    private int height;
    private int weight;
    private double bmi;
    private int glucose;
    
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getGlucose() {
        return glucose;
    }

    public void setGlucose(int glucose) {
        this.glucose = glucose;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getInsulinLevel() {
        return insulinLevel;
    }

    public void setInsulinLevel(int insulinLevel) {
        this.insulinLevel = insulinLevel;
    }

    public int getCholestrol() {
        return cholestrol;
    }

    public void setCholestrol(int cholestrol) {
        this.cholestrol = cholestrol;
    }

    public int getBphigh() {
        return bphigh;
    }

    public void setBphigh(int bphigh) {
        this.bphigh = bphigh;
    }

    public int getBplow() {
        return bplow;
    }

    public void setBplow(int bplow) {
        this.bplow = bplow;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

   

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
    
}
