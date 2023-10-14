package com.app.solid.d;

public class DebitCard implements BankCard {
    public void doTransaction(int amount) {
        System.out.println("tx done with DebitCard");
    }
}