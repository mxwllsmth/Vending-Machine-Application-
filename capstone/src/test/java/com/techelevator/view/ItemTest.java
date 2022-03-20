package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void returns_glug() {
        Beverages beverages = new Beverages();
        Assert.assertEquals("Glug Glug, Yum!", beverages.message());
    }

    @Test
    public void returns_crunch() {
        Chips chips = new Chips();
        Assert.assertEquals("Crunch Crunch, Yum!", chips.message());
    }

    @Test
    public void returns_chew() {
        Gum gum = new Gum();
        Item item = new Item();
        Assert.assertEquals("Chew Chew, Yum!", gum.message());
    }

    @Test
    public void returns_munch() {
        Candy candy = new Candy();
        Item item = new Item();
        Assert.assertEquals("Munch Munch, Yum!", candy.message());
    }
}
