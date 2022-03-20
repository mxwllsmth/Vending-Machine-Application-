package com.techelevator.view;

public class VendingMachine {

    public Money money = new Money();
    public Display display = new Display();

//GETTERS
    public Display getDisplay() {
        return display;
    }
    public Money getMoney() {
        return money;
    }
}
