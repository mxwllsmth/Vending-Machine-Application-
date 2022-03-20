package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends Item {

    //CONSTRUCTOR
    public Gum(String inputItem, BigDecimal valueOf, String inputItem1, int quantity) {
        super(inputItem, valueOf, inputItem1, quantity);
    }
    public Gum (Item item){};
    public Gum() {}

    public String message() {
        return "Chew Chew, Yum!";
    }

}
