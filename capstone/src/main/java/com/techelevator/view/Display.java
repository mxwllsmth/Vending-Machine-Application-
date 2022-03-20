package com.techelevator.view;

import com.techelevator.VendingMachineCLI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Display {

    static File inventoryFile = new File("vendingmachine.csv");
    public static List <String> slotList = new ArrayList<>();
    public static List<String> nameList = new ArrayList<>();
    public static List<BigDecimal> priceList = new ArrayList<>();
    public static List<String> typeList = new ArrayList<>();
    public static List<Integer> quantityList = new ArrayList<>(15);
    public static Map<String, Item> keyAndValueMap = new HashMap<>();
    public static String[] display = {};

    //READ FILE AND ADD TO LIST
    public static List<String> readFile(String[] args) {
        List<String> list = new ArrayList<>();
        try (Scanner userInput = new Scanner(inventoryFile)) {
            while (userInput.hasNextLine()) {
                list.add(userInput.nextLine());}
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;}

    //ORIGINAL DISPLAY MENU
/*    public static void displayMenu() {
        System.out.println("___________________________________________________________________________________________________________");
        System.out.println(Display.readFile(display).subList(0, 4));
        System.out.println(Display.readFile(display).subList(4, 8));
        System.out.println(Display.readFile(display).subList(8, 12));
        System.out.println(Display.readFile(display).subList(12, 16));
        System.out.println("___________________________________________________________________________________________________________");
    }*/

    //NEW DISPLAY MENU (UGLY CODE BUT BETTER DISPLAY)
    public static void newDisplayMenu() {
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(readFile(display).subList(0, 1) + " " + "Stock: " + quantityList.get(0).toString() + "     " + readFile(display).subList(1, 2) + " " + "Stock: " + quantityList.get(1).toString() +  "              " + readFile(display).subList(2, 3) + " " + "Stock: " + quantityList.get(2).toString() +  "          " + readFile(display).subList(3, 4) + " " + "Stock: " + quantityList.get(3).toString());
        System.out.println();
        System.out.println(readFile(display).subList(4, 5) + " " + "Stock: " + quantityList.get(4).toString() +  "          " + readFile(display).subList(5, 6) + " " + "Stock: " + quantityList.get(5).toString() +  "             " + readFile(display).subList(6, 7) + " " + "Stock: " + quantityList.get(6).toString() +  "           " + readFile(display).subList(7, 8) + " " + "Stock: " + quantityList.get(7).toString());
        System.out.println();
        System.out.println(readFile(display).subList(8, 9) + " " + "Stock: " + quantityList.get(8).toString() +  "             " + readFile(display).subList(9, 10) + " " + "Stock: " + quantityList.get(9).toString() + "             " + readFile(display).subList(10, 11) + " " + "Stock: " + quantityList.get(10).toString() +  "     " + readFile(display).subList(11, 12) + " " + "Stock: " + quantityList.get(11).toString());
        System.out.println();
        System.out.println(readFile(display).subList(12, 13) + " " + "Stock: " + quantityList.get(12).toString() +  "            " + readFile(display).subList(13, 14) + " " + "Stock: " + quantityList.get(13).toString() +  "     " + readFile(display).subList(14, 15) + " " + "Stock: " + quantityList.get(14).toString() +  "              " + readFile(display).subList(15, 16) + " " + "Stock: " + quantityList.get(15).toString());
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
    }

    //ITEM LISTS - SLOT - NAME - PRICE - TYPE
   public static Map<String, Item> itemMap(String[] args) {
        try (Scanner scanner = new Scanner(inventoryFile)) {
           while (scanner.hasNextLine()) {
              String inventoryString = scanner.nextLine();
             String[] inputItems = inventoryString.split("\\|");
             slotList.add(inputItems[0]);
              nameList.add(inputItems[1]);
               priceList.add(BigDecimal.valueOf(Double.parseDouble(inputItems[2])));
               typeList.add(inputItems[3]);
            }
        } catch(
        FileNotFoundException e)

        {e.getMessage();
        }
            return keyAndValueMap;
    }

    //QUANTITY LIST - SIXTEEN FIVE
    public static List<Integer> getQuantityList(List slotList) {
    //  public static void getQuantity (){
        for (int i = 0; i < slotList.size()+1; i++){
            quantityList.add(5);
        }
        return quantityList;
    }

}

 //Old map with lists added

/*public static Map<String, Item> itemMap(String[] args) {
      String inventoryString = inventoryFile;
      keyAndValueMap = new HashMap<String, Item>();
    try (Scanner scanner = new Scanner(inventoryFile)) {
        while (scanner.hasNextLine()) {
            String inventoryString = scanner.nextLine();
            String[] inputItems = inventoryString.split("\\|");
            slotList.add(inputItems[0]);
            nameList.add(inputItems[1]);
            priceList.add(BigDecimal.valueOf(Double.parseDouble(inputItems[2])));
            typeList.add(inputItems[3]);
                    keyAndValueMap.put(inputItems[0], inputItems[2]);
                if (inputItems[3].equals("Drink")){
                    keyAndValueMap.put(inputItems[0], new Beverages(inputItems[1], BigDecimal.valueOf(Double.parseDouble(inputItems[2])),inputItems[3],5));
                    System.out.println(keyAndValueMap.get(inputItems[0]);
                }
                else if (inputItems[3].equals("Chip")){
                    keyAndValueMap.put(inputItems[0], new Chips(inputItems[1], BigDecimal.valueOf(Double.parseDouble(inputItems[2])),inputItems[3], 5));
                }
                else if (inputItems[3].equals("Candy")){
                    keyAndValueMap.put(inputItems[0], new Candy(inputItems[1], BigDecimal.valueOf(Double.parseDouble(inputItems[2])),inputItems[3], 5));
                }
                else if (inputItems[3].equals("Gum")){
                    keyAndValueMap.put(inputItems[0], new Gum(inputItems[1], BigDecimal.valueOf(Double.parseDouble(inputItems[2])),inputItems[3],5 ));
                }
        }
    } catch(
            FileNotFoundException e)

    {e.getMessage();
    }
    return keyAndValueMap;
}*/


