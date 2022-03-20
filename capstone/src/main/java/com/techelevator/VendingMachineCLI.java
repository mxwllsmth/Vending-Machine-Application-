package com.techelevator;
import com.techelevator.view.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	//MAIN MENU FINAL VARIABLES
	private static final String MMO_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MMO_PURCHASE = "Purchase";
	private static final String EXIT = "Exit";
	private static final String[] MM_OPTIONS = {MMO_DISPLAY_ITEMS, MMO_PURCHASE, EXIT};

	//PURCHASE MENU FINAL VARIABLES
	private static final String PMO = "Feed money";
	private static final String PM0_SELECT_PRODUCT = "Select Product";
	private static final String PMO_FINISH = "Finish Transaction";
	private static final String[] PMO_OPTIONS = {PMO, PM0_SELECT_PRODUCT, PMO_FINISH};

	//PRIVATE VARIABLES
	private Menu menu;
	private VendingMachine VendingMachine = new VendingMachine();
	private String list;

	//PUBLIC VARIABLES
	public static String selection;
	public static String slotNumber = "";
	public static BigDecimal currentPrice;
	public static BigDecimal finalBalance = new BigDecimal(0);
	public static Integer currentQuantity;
	public static String currentName;
	public static int currentIndex;
	public Money money = new Money();
	public Display display;
	public Item item = new Item();
	public Map<String, Item> kvMap = Display.keyAndValueMap;
	public Beverages beverage = new Beverages(kvMap.get(slotNumber));
	public Chips chip = new Chips(kvMap.get(slotNumber));
	public Gum gum = new Gum(kvMap.get(slotNumber));
	public Candy candy = new Candy(kvMap.get(slotNumber));


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.VendingMachine = new VendingMachine();
	}

	public VendingMachineCLI() {}

	public Menu getMenu() {
		return menu;
	}
	public String getList() {
		return list;
	}

	public void run() {
		String[] display = {};
		String[] mapOfItems = {};
		Display.itemMap(mapOfItems);
		List<String> slots = Display.slotList;
		List<String> names = Display.nameList;
		List<BigDecimal> prices = Display.priceList;
		List<String> types = Display.typeList;
		List<Integer> quantity = Display.getQuantityList(slots);

			//GET CHOICE FROM MAIN MENU OPTIONS
			while (true) {
			String choice = (String) menu.getChoiceFromOptions(MM_OPTIONS);
			Scanner purchaseScanner = new Scanner(System.in);

			//DISPLAY MENU
			if (choice.equals(MMO_DISPLAY_ITEMS)) {
				Display.newDisplayMenu();
				//GO TO PURCHASE MENU
			} else if (choice.equals(MMO_PURCHASE)) {
					while (true) {
						choice = (String) menu.getChoiceFromOptions(PMO_OPTIONS);
						//FEED MONEY
						if (choice.equals(PMO)) {
							System.out.println();
							System.out.println("* Vending Machine will only accepts $1, $2, $5, and $10 dollar bills *");
							System.out.println();
							System.out.print("Please enter the selected dollar amount : ");
							System.out.println();
							selection = purchaseScanner.nextLine();
							if (!(selection.equals("1")) && !(selection.equals("2")) && !(selection.equals("5")) && !(selection.equals("10"))) {
								System.out.println("Sorry, we only accepts $1, $2, $5, and $10 dollar bills.");
							} else
								money.feedMoney(selection);
							//SELECT PRODUCT
						} else if (choice.equals(PM0_SELECT_PRODUCT)) {
							Display.newDisplayMenu();
							//CATCH INVALID SLOT
							System.out.print("Please enter a slot number: ");
							slotNumber = purchaseScanner.nextLine();
								if ( !slots.contains(slotNumber)) {
									System.out.println("Sorry, that isn't a valid slot number.");
								}
							currentIndex = slots.indexOf(slotNumber);
							currentName = names.get(currentIndex);
							currentPrice = prices.get(currentIndex);
							currentQuantity = quantity.get(currentIndex);
							//CATCH SOLD OUT
							int result = (Money.balance.compareTo(currentPrice));
							if (currentQuantity <=0){
								System.out.println("Sold out!");}
							else {
								//CATCH INSUFFICIENT FUNDS
								if (result == -1) {
									System.out.println("Sorry, your balance is too low to purchase this item.");
									VendingMachineCLI.finalBalance = Money.balance;
								} else {
									//DISPENSE ITEM
									System.out.println("Your selected: " + currentName + " for $" + currentPrice);
									if (types.get(currentIndex).equals("Drink")) {
										System.out.println("Dispensing " + currentName + ", " + beverage.message());
										System.out.println("Your balance is now " + "$" + money.makePurchase(currentPrice));
									} else if (types.get(currentIndex).equals("Chip")) {
										System.out.println("Dispensing " + currentName + ", " + chip.message());
										System.out.println("Your balance is now " + "$" + money.makePurchase(currentPrice));
									} else if (types.get(currentIndex).equals("Gum")) {
										System.out.println("Dispensing " + currentName + ", " + gum.message());
										System.out.println("Your balance is now " + "$" + money.makePurchase(currentPrice));
									} else if (types.get(currentIndex).equals("Candy")) {
										System.out.println("Dispensing " + currentName + ", " + candy.message());
										System.out.println("Your balance is now " + "$" + money.makePurchase(currentPrice));
									}
								}
							}
						} else if (choice.equals(PMO_FINISH)) {
							money.makeChange();
							break;
						}
					}
		} else if (choice.equals(EXIT)) {
			System.exit(0);
		}
	}
}
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
