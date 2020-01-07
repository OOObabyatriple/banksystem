package tests;

import com.qa.bankingsystem.Account;
import com.qa.bankingsystem.CreditAccount;
import com.qa.bankingsystem.InterestRate;
import com.qa.bankingsystem.Transaction;

import javax.swing.*;

public class MainUnit {
    public static void main(String[] args){

        test_current_balance_equals_available_balance();

        test_does_balance_match_after_credit();

        test_does_balance_match_after_debit();

        test_is_interest_charged_with_negative_balance();
       // Account acc =new Account(890,"Billy goat",50);
       // System.out.println(acc.currentBalance());
       //acc.availableBalance();
       //System.out.println(acc.availableBalance());
       //acc.Credit(3570);
       // System.out.println(acc.availableBalance());
       // System.out.println(acc.currentBalance());

    }

    public static void test_current_balance_equals_available_balance(){
        double openingBalance = 56.78;

        Account account = new Account(1,"Eric", openingBalance);

        //assert
        if(openingBalance== account.availableBalance() && openingBalance ==account.currentBalance()){
            System.out.println("All good");
        }
        else{
            System.out.println("ooops");
        }
    }
    public static void test_does_balance_match_after_credit(){
        //arrange
        double openingBalance2=56.78;
        double amounttodeposit=44.00;
        Account account2 = new Account(2,"Eric", openingBalance2);

        //act
        account2.Credit(amounttodeposit);

        //assert
        if((openingBalance2+amounttodeposit)==account2.availableBalance() && (openingBalance2+amounttodeposit)==account2.currentBalance()){
            System.out.println("All good");
        }
        else{
            System.out.println("bad");
        }
    }
    public static void test_does_balance_match_after_debit(){
        //arrange
        double openingBalance2=56.00;
        double amounttowithdraw=44.00;
        Account account3 = new Account(3,"Eric", openingBalance2);

        //act
        account3.Debit(amounttowithdraw);
        System.out.println(account3.availableBalance());
        System.out.println(account3.currentBalance());
        //assert
        if((openingBalance2-amounttowithdraw)==account3.availableBalance() && (openingBalance2-amounttowithdraw)==account3.currentBalance()){
            System.out.println("All good");
        }
        else{
            System.out.println("bad");
        }
    }
    public static void test_is_interest_charged_with_negative_balance(){
        double openingBalance=5;
        double amounttodebit=10;
        Account account4 = new CreditAccount(4,"Hi", openingBalance,InterestRate.BUSINESS_LOAN);

        account4.Debit(amounttodebit);

        amounttodebit+=amounttodebit* InterestRate.BUSINESS_LOAN.getRate()/100;

        System.out.println(account4.availableBalance());
        System.out.println(account4.currentBalance());

        //assert
        if((openingBalance-amounttodebit)==account4.availableBalance() && (openingBalance-amounttodebit)==account4.currentBalance()){
            System.out.println("All good");
        }
        else{
            System.out.println("bad");
        }
    }
}
