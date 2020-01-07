package com.qa.bankingsystem;

public class CreditAccount extends Account {

    InterestRate interestRate;

    public CreditAccount(int id, String name, double balance, InterestRate interestRate) {
        super(id, name, balance);
        this.interestRate=interestRate;
    }

    @Override
    public double Debit(double withdrawal) {

        if(super.availableBalance()-withdrawal<0){
            withdrawal+=(interestRate.getRate()/100)*withdrawal;
        }
        super.Debit(withdrawal);
        return super.availableBalance();
    }

   // public double calculateCredit(double balance, InterestRate interestRate){
   //     if(balance<0){
   //         balance+=(balance*interestRate.getRate());
    //    }
     //   return balance;
    //}
}
