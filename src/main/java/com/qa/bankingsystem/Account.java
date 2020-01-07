package com.qa.bankingsystem;

import java.util.AbstractList;
import java.util.ArrayList;

public class Account {
    private final int id;
    private final String name;
    private double balance;
    private final AbstractList<Transaction> transactionArrayList = new ArrayList<>();

    public Account(int id, String name, double amount){
        this.id = id;
        this.name=name;
        Credit(amount);
    }

    public double Credit(double deposit){
        balance+=deposit;
        transactionArrayList.add(new Transaction(deposit));

        return balance;
    }

    public double Debit(double withdrawal){
        balance+=withdrawal * -1;
        transactionArrayList.add(new Transaction(withdrawal*-1));

        return balance;
    }

    public double availableBalance(){
        this.balance=balance;

        return balance;
    }

    public double currentBalance(){
        this.balance=balance;
        double balance =0;
        for(Transaction txn: transactionArrayList){
            balance +=txn.getAmount();
        }
        return balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
