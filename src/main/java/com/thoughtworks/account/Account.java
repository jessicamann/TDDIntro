package com.thoughtworks.account;

/**
 * Created by jessicamann on 6/8/15.
 */
public class Account {
    private int balance;

    public Account(int amt){
        this.balance = amt;
    }

    public int balance(){
        return balance;
    }

    public int deposit(int amt) {
        balance += amt;
        return balance;
    }
    public float withdraw(int amt){
        if(balance>amt){
            balance-=amt;
        }
        return balance;
    }
}
