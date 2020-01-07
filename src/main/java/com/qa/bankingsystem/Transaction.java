package com.qa.bankingsystem;


import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.Instant;

public class Transaction {
    private double amount;
    private Instant date = Instant.now();

    public Transaction(double amount){
        this.amount=amount;
    }
    public String getDate(){
        return date.toString();
    }
    public double getAmount(){
        return amount;
    }
}
