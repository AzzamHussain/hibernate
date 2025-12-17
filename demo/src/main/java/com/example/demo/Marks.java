package com.example.demo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Marks {
    private double engmarks;
    private double mathmarks;
    private double  scimarks;
    public double getEngmarks() {
        return engmarks;
    }
    public void setEngmarks(double engmarks) {
        this.engmarks = engmarks;
    }
    public double getMathmarks() {
        return mathmarks;
    }
    public void setMathmarks(double mathmarks) {
        this.mathmarks = mathmarks;
    }
    public double getScimarks() {
        return scimarks;
    }
    public void setScimarks(double scimarks) {
        this.scimarks = scimarks;
    }

}
