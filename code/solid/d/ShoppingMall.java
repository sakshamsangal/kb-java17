package com.app.solid.d;

public class ShoppingMall {
    private final BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public static void main(String[] args) {
        BankCard bankCard = new CreditCard();
        ShoppingMall shoppingMall1 = new ShoppingMall(bankCard);
        shoppingMall1.doPayment("do some order", 10000);
    }

    public void doPayment(Object order, int amount) {
        bankCard.doTransaction(amount);
    }
}