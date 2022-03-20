package com.techelevator.view;

import java.math.BigDecimal;

public class Chips extends Item {

    public Chips(String inputItem, BigDecimal valueOf, String inputItem1, int quantity) {
        super(inputItem, valueOf, inputItem1, quantity);
    }
    public Chips(Item item) {};
    public Chips() {}
    public String message() {
        return "Crunch Crunch, Yum!";
    }


}
