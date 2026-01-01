package com.guild.inventory;

import java.util.ArrayList;
import java.util.List;

public class MagicInventoryItemTest {
    public static void main(String[] args) {
       System.out.println("--- Magic Inventory Item Test ---");

       //create multiple objects using both constructors
        MagicInventoryItem item1 = new MagicInventoryItem(); //unamed Magic Item, null stock
        MagicInventoryItem item2 = new MagicInventoryItem("Potion", 500);
        MagicInventoryItem item3 = new MagicInventoryItem("Enchancted Scroll", 10);

        System.out.println("Item 1 ID: " + item1.getItemId() + ", Stock: " + item1.getStock());
        System.out.println("Item 2 ID: " + item2.getItemId() + ", Stock: " + item2.getStock());
        System.out.println("Item 3 ID: " + item3.getItemId() + ", Stock: " + item3.getStock());
        
        //test setStock method with valid and invalid values
        System.out.println("\n--- Testing Stock Validation & Truncation ---");

        //valid stock
        item1.setStock(250);
        System.out.println("Updated Item 1 Stock :" + item1.getStock());

        //testing stock exceeding MAX_STOCK
        MagicInventoryItem overstockedItem = new MagicInventoryItem("Elemental Stones", 1200);
        System.out.println("Overstocked Item (Input 1200) Result: " + overstockedItem.getStock());

        //test negative stock
        try {
            System.out.println("Attempting to set negative stock (-10)...");
            item3.setStock(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        //test calcultateTotalStock method
        System.out.println("\n--- Testing Total Stock Calculation ---");

        //empty list
        List<MagicInventoryItem> emptyList = new ArrayList<>();
        System.out.println("Empty list total stock: " + MagicInventoryItem.calculateTotalStock(emptyList));

        //single item list
        List<MagicInventoryItem> singleItemList = new ArrayList<>();
        singleItemList.add(item2); //Potion with 500 stock
        System.out.println("Single Item list total stock: " + MagicInventoryItem.calculateTotalStock(singleItemList));

        //multiple items list
        List<MagicInventoryItem> multipleItemsList = new ArrayList<>();
        multipleItemsList.add(item1); //250 stock
        multipleItemsList.add(item2); //500 stock
        multipleItemsList.add(item3); //10 stock
        multipleItemsList.add(overstockedItem); //1000 stock (truncated)
        
        System.out.println("Multiple Items list total stock: " + MagicInventoryItem.calculateTotalStock(multipleItemsList));

        //test total number of inventory items
        System.out.println("\n--- Final count check ---");
        System.out.println("Total Items Created: " + MagicInventoryItem.getTotalItems());

        }
    }