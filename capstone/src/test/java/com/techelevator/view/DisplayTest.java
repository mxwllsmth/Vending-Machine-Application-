package com.techelevator.view;


import org.junit.Assert;
import org.junit.Test;

public class DisplayTest {

    @Test
    public void returns_glug() {
        Beverages beverages = new Beverages();
        Assert.assertEquals("Glug Glug, Yum!", beverages.message());
    }

}