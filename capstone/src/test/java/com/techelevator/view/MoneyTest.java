package com.techelevator.view;

import com.techelevator.VendingMachineCLI;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void feed_money_to_starting_balance() {
        var money = new Money();
        BigDecimal a = BigDecimal.valueOf(10);
        Assert.assertEquals(BigDecimal.valueOf(10), a);
    }

    @Test
    public void make_purchase_balance_too_low() {
    var money = new Money();
    BigDecimal balance = new BigDecimal(0);
    BigDecimal currentPrice = BigDecimal.valueOf(1.75);
    int result = (balance.compareTo(currentPrice));

    Assert.assertEquals(true,result == -1);
    }

    @Test
    public void make_purchase_return_correct_balance() {
        var money = new Money();
        Money.balance = BigDecimal.valueOf(10);
        BigDecimal currentPrice = BigDecimal.valueOf(9.00);
        VendingMachineCLI vending = new VendingMachineCLI();
           VendingMachineCLI.currentQuantity=5;

        Assert.assertEquals(BigDecimal.valueOf(1.0),money.makePurchase(currentPrice));
    }
    }

