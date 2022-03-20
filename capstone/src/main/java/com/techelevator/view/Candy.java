package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Item {

    public Candy(String inputItem, BigDecimal valueOf, String inputItem1, int quantity) {
        super(inputItem, valueOf, inputItem1, quantity);
    }

    public Candy(Item item) {};
    public Candy() {}

    public String message() {
        return "Munch Munch, Yum!";
    }
}
