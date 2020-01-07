package com.qa.bankingsystem;

public enum InterestRate {

    HOME_LOAN(3.5),
    BUSINESS_LOAN(5.5);

    private double rate;
    InterestRate(double rate){
        this.rate=rate;
    }
    public double getRate(){
        return rate;
    }
}
