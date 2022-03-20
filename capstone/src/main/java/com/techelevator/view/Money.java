package com.techelevator.view;

import com.techelevator.VendingMachineCLI;

import java.math.BigDecimal;

public class Money {

    public static BigDecimal balance = new BigDecimal(0);
    public Money() {
    }
    public Display display;
    public VendingMachineCLI cli;
    String[] mapOfItems = {};
    private static Logger appLog = new Logger("log.txt");

    //ADD MONEY - UPDATE BALANCE - LOG
    public void feedMoney(String selection) {
        balance = BigDecimal.valueOf(Double.parseDouble(String.valueOf(balance)));
        balance = balance.add(BigDecimal.valueOf(Double.parseDouble(selection)));
        System.out.println("Your balance is now $" + balance);
        try{appLog.purchaseLog("Feed Money", balance, VendingMachineCLI.finalBalance);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //BUY SOMETHING - UPDATE BALANCE - REDUCE INVENTORY - LOG
    public BigDecimal makePurchase( BigDecimal currentPrice) {
        int result = (balance.compareTo(currentPrice));
        if (result == -1) {
            System.out.println("Sorry but your balance is too low to purchase this item.");
            VendingMachineCLI.finalBalance = balance;
        } else {
            VendingMachineCLI.finalBalance = balance.subtract(currentPrice);
            balance = balance.subtract(currentPrice);
            int quantityDecrease =  VendingMachineCLI.currentQuantity -= 1;

            Display.quantityList.add(VendingMachineCLI.currentIndex, quantityDecrease);
        }
            appLog.itemLog(VendingMachineCLI.currentName, VendingMachineCLI.slotNumber, balance, VendingMachineCLI.finalBalance);
            return VendingMachineCLI.finalBalance;
    }

    public void makeChange() {
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        BigDecimal x = VendingMachineCLI.finalBalance;
        int result = (x.compareTo(BigDecimal.valueOf(Long.parseLong("0"))));
        int result2;

        while (result > 0) {
            result = (x.compareTo(BigDecimal.valueOf(.25)));
            if (result == 1 || result == 0) {
                x = x.subtract(BigDecimal.valueOf(.25));
                quarterCount++;
            } else {
                result = (x.compareTo(BigDecimal.valueOf(.10)));
                result2 = (x.compareTo(BigDecimal.valueOf(.25)));
                if ((result == 1 || result == 0) && (result2 == -1)) {
                    x = x.subtract(BigDecimal.valueOf(.10));
                    dimeCount++;
                } else {
                    x = x.subtract(BigDecimal.valueOf(.05));
                    nickelCount++;
                }
            }
        }
        System.out.println("Dispensing $" +VendingMachineCLI.finalBalance+ " in " +quarterCount+ " quarters " +dimeCount+ " dimes " +nickelCount+ " nickels ");
        balance = new BigDecimal(0);

        try{
            appLog.purchaseLog("Make Change", balance, VendingMachineCLI.finalBalance);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}